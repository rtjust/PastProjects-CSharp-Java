using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.DirectoryServices.AccountManagement;

namespace VNCDash
{
    public class WinUserInfo
    {
        // Constructor used to set initial username and password values
        public WinUserInfo(string userName, string passWord, string domain)
        {
            this.givenUserName = userName;
            this.givenPassWord = passWord;
            this.givenDomain = domain;
        }


        // Private field to store UserPrincipal
        private UserPrincipal userPrincipal;
        private PrincipalContext context;
        private PrincipalSearchResult<Principal> userGroups;

        // Read-only Property UserName. Use to get UserName that was passed through constructor
        private string givenUserName;
        public string GivenUserName
        {
            get { return givenUserName; }
        }

        // Read-only property password. Used to get password that was passed through constructor
        private string givenPassWord;
        public string GivenPassWord
        {
            get { return givenPassWord; }
        }

        private string givenDomain;
        public string GivenDomain
        {
            get { return givenDomain; }
        }

        // Checks username and password to see if they are valid and returns true if yes.
        public bool ValidateCredentials()
        {
            if (context.ValidateCredentials(givenUserName, givenPassWord))
                return true;
            else
                return false;
        }

        public bool IsEnabled()
        {
            return userPrincipal.Enabled.Value;
        }

        public string GetFirstName()
        {
            return userPrincipal.GivenName;
        }

        public string GetInitial()
        {
            return userPrincipal.MiddleName;
        }

        public string GetLastName()
        {
            return userPrincipal.Surname;
        }

        public List<string> GetGroups()
        {
            List<string> groupList = new List<string>();

            foreach (GroupPrincipal g in userGroups)
            {
                groupList.Add(g.Name);
            }

            return groupList;
        }


        public bool CreateUserPrincipal()
        {
            // Create connection to domain and do a search for the user
            try
            {
                context = new PrincipalContext(ContextType.Domain, givenDomain);

                    UserPrincipal tempUserPrincipal = new UserPrincipal(context);
                    tempUserPrincipal.SamAccountName = givenUserName;

                    // Search for user
                    PrincipalSearcher searchUser = new PrincipalSearcher();
                    searchUser.QueryFilter = tempUserPrincipal;

                    UserPrincipal foundUser = (UserPrincipal)searchUser.FindOne();

                    userPrincipal = foundUser;
                    userGroups = userPrincipal.GetGroups();
                    return true;

            }
            catch (PrincipalServerDownException)
            {
                System.Windows.Forms.MessageBox.Show("Cannot contact the server.");
                return false;
            }
            catch (Exception e)
            {
                System.Windows.Forms.MessageBox.Show(e.Message, "Unknown Error", System.Windows.Forms.MessageBoxButtons.OK, System.Windows.Forms.MessageBoxIcon.Error);
                return false;
            }

        }

    }
}
