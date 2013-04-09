using System;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.DirectoryServices.AccountManagement;
using System.IO;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        
        public Form1()
        {
            InitializeComponent();
            string currentDomain = System.Environment.UserDomainName.ToUpper();
            gboxValidate.Text += currentDomain;
        }

        private void btnValidate_Click(object sender, EventArgs e)
        {
            ResetForm();
            GetUserDetails();
        }

        private void GetUserDetails()
        {
            string currentDomain = System.Environment.UserDomainName.ToUpper();
            WinUserInfo newUser = new WinUserInfo(txtUser.Text, txtPass.Text, currentDomain);

            if (!newUser.CreateUserPrincipal())
            {
                lblValid.Text = "Unknown User '" + newUser.GivenUserName + "'";
                lblValid.BackColor = Color.Red;
                lblValid.ForeColor = Color.White;
                lblValid.Image = WindowsFormsApplication1.Properties.Resources.delete241;
            }
            else
            {
                if (newUser.ValidateCredentials())
                {
                    lblValid.Text = "Valid password for user '" + newUser.GivenUserName + "'";
                    lblValid.BackColor = Color.Green;
                    lblValid.ForeColor = Color.White;
                    lblValid.Image = WindowsFormsApplication1.Properties.Resources.accept24;

                }
                else
                {
                    lblValid.Text = "Invalid password for user '" + newUser.GivenUserName + "'";
                    lblValid.BackColor = Color.Red;
                    lblValid.ForeColor = Color.White;
                    lblValid.Image = WindowsFormsApplication1.Properties.Resources.delete241;
                }
                gboxUser.Text = "User Summary for: " + newUser.GivenUserName;
                lblFirstName.Text = newUser.GetFirstName();
                lblLastName.Text = newUser.GetLastName();
                lblInitial.Text = newUser.GetInitial();
                chkEnabled.Checked = newUser.IsEnabled();
                foreach (string s in newUser.GetGroups())
                {
                    listMemberOf.Items.Add(s);
                }

            }
        }

        private void ResetForm()
        {
            // Clear the data in the form controls
            lblFirstName.Text = "";
            lblLastName.Text = "";
            lblInitial.Text = "";
            chkEnabled.Checked = false;
            listMemberOf.Items.Clear();

            lblValid.Text = "";
            lblValid.BackColor = Color.Empty;
            lblValid.ForeColor = Color.Empty;
        }

        private void txtUser_TextChanged(object sender, EventArgs e)
        {
            // Checks to see if there are any leading or trailer spaces and removes them
            txtUser.Text = txtUser.Text.Trim();

            // If nothing is typed in the username field then do not allow the user to click Validate button
            if (!String.IsNullOrEmpty(txtUser.Text))
            {
                btnValidate.Enabled = true;
            }
            else
            {
                btnValidate.Enabled = false;
            }
        }

    }
}
