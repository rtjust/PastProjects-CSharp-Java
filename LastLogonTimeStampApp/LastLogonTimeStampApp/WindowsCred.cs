using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.DirectoryServices.AccountManagement;
using System.DirectoryServices;
using System.Management;
using System.Windows.Forms;


namespace LastLogonTimeStampApp
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

        public static String[,] EnumerateComputersAndLastLogonTimeStamp()
        {
            List<SearchResult> computerList = new List<SearchResult>(EnumerateComputers());
          //  List<DateTime> lastLogonTimeStampList = new List<DateTime>();
            String[,] computerAndTimeStamp = new String[computerList.Count, computerList.Count];

            ResultPropertyCollection myResultPropColl;
            int i = 0;
            foreach (SearchResult computer in computerList)
            {
                long lastLogonTimeStamp;
                DateTime dateTime = new DateTime();
                myResultPropColl = computer.Properties;

                if (computer.Properties.Contains("lastlogontimestamp"))
                {
                    lastLogonTimeStamp = (long)(myResultPropColl["lastlogontimestamp"][0]);
                    dateTime = DateTime.FromFileTime(lastLogonTimeStamp);
                    //lastLogonTimeStampList.Add(dateTime);
                    computerAndTimeStamp[i, 0] = computer.GetDirectoryEntry().Name.Substring(3).ToUpper();
                    computerAndTimeStamp[i, 1] = dateTime.ToLongDateString();

                }
                else
                {
                    computerAndTimeStamp[i, 0] = computer.GetDirectoryEntry().Name.Substring(3).ToUpper();
                    computerAndTimeStamp[i, 1] = "No timestamp";
                }
                    
                i++; 
            }

            return computerAndTimeStamp;
            
           
            /* foreach (string myKey in myResultPropColl.PropertyNames)
            {
                properties += myKey + " = ";
                foreach (Object myCollection in myResultPropColl[myKey])
                {
                    properties += myCollection + "\n";
                }
            }
            *
            MessageBox.Show(properties);*/

            
            //System.DateTime dateTime = new System.DateTime(1601, 1, 1, 0, 0, 0, 0);

            //   System.DateTime dateTime2 = System.DateTime.FromFileTime(Convert.ToInt64(myResultPropColl["lastlogontimestamp"].ToString()));

            // Add the number of seconds in UNIX timestamp to be converted.
            // ulong timestamp = Convert.();
            //dateTime = dateTime.AddMilliseconds(timestamp);

            // The dateTime now contains the right date/time so to format the string,

            // use the standard formatting methods of the DateTime object.

            //string printDate = dateTime2.ToShortDateString() +" "+ dateTime2.ToShortTimeString();
            // MessageBox.Show(dateTime2.ToString());
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

      
    }
}
