using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.DirectoryServices.AccountManagement;


namespace WindowsFormsApplication1
{
    public class WindowsCred
    {
        //private const string SPLIT_1 = "\\";
        public static int ValidateW(string UserName, string Password)
        {
            bool valid = false;
            string Domain = System.Environment.UserDomainName;


            /* if (UserName.IndexOf("\\") != -1)
             {
                 string[] arrT = UserName.Split(SPLIT_1[0]);
                Domain = arrT[0];
                 UserName = arrT[1];
             } 

             if (Domain.ToUpper() != System.Environment.UserDomainName.ToUpper())
             {
                 return valid;
             }
             */

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
