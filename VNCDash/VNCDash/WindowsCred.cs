using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.DirectoryServices.AccountManagement;
using System.DirectoryServices;
using System.Management;
using System.Windows.Forms;


namespace VNCDash
{
    public static class WindowsCred
    {
        public static String GetDomain()
        {
            string domain = System.Environment.UserDomainName;

            if (domain.Length == 0)
            {
                domain = System.Environment.MachineName;
            }

            return domain;
        }
        
        public static List<SearchResult> EnumerateComputers()
        {
            string domain = System.Environment.UserDomainName;
            List<SearchResult> computerList = new List<SearchResult>();

            if (domain.Length == 0)
            {
                domain = System.Environment.MachineName;
            }

            try
            {
                DirectoryEntry directoryEntry = new DirectoryEntry("LDAP://" + domain);
                DirectorySearcher compSearcher = new DirectorySearcher(directoryEntry);
                compSearcher.SizeLimit = 100000;
                compSearcher.PageSize = 1000;
                compSearcher.Filter = "ObjectCategory=computer";
                foreach (SearchResult computer in compSearcher.FindAll())
                {
                    computerList.Add(computer); 
                }

            }
            catch (Exception e)
            {
                System.Windows.Forms.MessageBox.Show(e.Message, "There was an error!", System.Windows.Forms.MessageBoxButtons.OK, System.Windows.Forms.MessageBoxIcon.Error);
            }

            return computerList;


        }
        
        public static int ValidateW(string UserName, string Password)
        {
            bool valid = false;
            string Domain = System.Environment.UserDomainName;

            if (Domain.Length == 0)
            {
                Domain = System.Environment.MachineName;

            }

            try
            {
                using (PrincipalContext context = new PrincipalContext(ContextType.Domain, Domain))
                {
                    valid = context.ValidateCredentials(UserName, Password);
                    if (valid)
                    {
                        UserPrincipal userPrincipal = new UserPrincipal(context);
                        userPrincipal.SamAccountName = UserName;

                        // Search for user
                        PrincipalSearcher searchUser = new PrincipalSearcher();
                        searchUser.QueryFilter = userPrincipal;

                        UserPrincipal foundUser = (UserPrincipal)searchUser.FindOne();

                        // Get groups
                        PrincipalSearchResult<Principal> groups = foundUser.GetGroups();
                        foreach (GroupPrincipal g in groups)
                        {
                            System.Windows.Forms.MessageBox.Show(g.Name);
                        }

                        // Get Enabled Statud
                        System.Windows.Forms.MessageBox.Show("Enabled: " + foundUser.Enabled.ToString());
                        System.Windows.Forms.MessageBox.Show(foundUser.DisplayName);

                        return 1; //True, validation successful
                    }

                    return 0; //False, validation unsucessful


                }
            }
            catch (Exception e)
            {
                System.Windows.Forms.MessageBox.Show(e.Message, "There was an error!", System.Windows.Forms.MessageBoxButtons.OK, System.Windows.Forms.MessageBoxIcon.Error);
                return 2; //ERROR! The server could not be contacted
            }
        }

        public static String GetLoggedOnUser(String computerName)
        {
            try
            {
                ManagementScope theScope = new ManagementScope("\\\\" + computerName + "\\root\\cimv2");

                ObjectQuery theQuery = new ObjectQuery("SELECT username FROM Win32_ComputerSystem");

                ManagementObjectSearcher theSearcher = new ManagementObjectSearcher(theScope, theQuery);

                ManagementObjectCollection theCollection = theSearcher.Get();

                foreach (ManagementObject theCurObject in theCollection)
                {
                    return theCurObject["username"].ToString().Split('\\')[1];
                }
            }
            catch (NullReferenceException)
            {
                return "No User";
            }
            catch (Exception e)
            {
                return "Error";
            }
            return "Error";
        }
    }
}
