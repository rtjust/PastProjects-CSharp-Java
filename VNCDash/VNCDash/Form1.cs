using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Diagnostics;
using System.Net.NetworkInformation;
using System.Net;
using System.Threading;
using System.DirectoryServices;

namespace VNCDash
{
    public partial class Form1 : Form
    {
        // Debug, computer not part of domain, populate list with vms
        private const bool DEBUG = false;

        public Form1()
        {
            InitializeComponent();
            PingListView.ListViewToPing = listviewComputers;
        }

        private void btnScan_Click(object sender, EventArgs e)
        {
            statusLabel.Text = "Scanning domain " + WindowsCred.GetDomain() + " for computers... Please Wait.";
            Application.DoEvents();

            // Enumerate computers in domain, add to listviewComputers control
            listviewComputers.Items.Clear();

            ListView.ListViewItemCollection listItems = new ListView.ListViewItemCollection(listviewComputers);
            if (DEBUG)
            {
                String[] debugComputers = new String[] { "DCMAIN", "ROBTEST-PC", "ROB-PC" };
                foreach (String computer in debugComputers)
                {
                    ListViewItem newItem = new ListViewItem(computer);
                    listItems.Add(newItem);
                }
            }
            else
            {
                foreach (SearchResult computer in WindowsCred.EnumerateComputers())
                {

                    ListViewItem newItem = new ListViewItem(computer.GetDirectoryEntry().Name.Substring(3).ToUpper());
                    listItems.Add(newItem);

                }
                
            }
            
            // Update label to display domain
            lblDomain.Text = "Computers in domain: " + WindowsCred.GetDomain();
            statusLabel.Text = "Scan Domain complete.";

            Application.DoEvents();

            PingListView.PingAll();

            label4.Text = "Computers: " + listviewComputers.Items.Count.ToString();
        }

        private void btnConnect_Click(object sender, EventArgs e)
        {
            connectVNC(GetSelectedComputer());
        }

        private void connectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            connectVNC(GetSelectedComputer());
        }

        private void listviewComputers_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            connectVNC(GetSelectedComputer());
        }

        private void connectVNC(ListViewItem computer)
        {
            // Start vncviewer.exe with computerName as an argument
            if (computer.Text.Trim().Length != 0)
            {
                String viewOnly = "";
                if (chkViewOnly.Checked)
                {
                    viewOnly = " -viewonly";
                }

                ProcessStartInfo processInfo = new ProcessStartInfo();
                // processInfo.Verb = "runas";
                processInfo.FileName = "vncviewer.exe";
                processInfo.Arguments = " /user " + txtUser.Text + " /password " + txtPass.Text + viewOnly + " " +  computer.Text;
                Process.Start(processInfo);
            }
        }

        private ListViewItem GetSelectedComputer()
        {
            // Get the currently selected computer item
            ListViewItem selectedComputer = new ListViewItem();

            foreach(ListViewItem selectedItem in listviewComputers.SelectedItems)
            {
                selectedComputer = selectedItem;
            }
     
            return selectedComputer;
        }

        private void pingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (GetSelectedComputer() != null)
            {
                PingListView.PingComputer(GetSelectedComputer());
            }
        }

        private void txtSearch_TextChanged(object sender, EventArgs e)
        {
            // Call FindItemWithText with the contents of the textbox.

            if (listviewComputers.Items.Count > 0)
            {
                ListViewItem foundItem = listviewComputers.FindItemWithText(txtSearch.Text, false, 0);
                if (foundItem != null)
                {
                    listviewComputers.TopItem = foundItem;
                    foundItem.Selected = true;
                }
            }
        }

        private void txtSearch_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                foreach (ListViewItem selectedItem in listviewComputers.SelectedItems)
                {
                    connectVNC(selectedItem);
                }
            }
        }

        private void btnPingAll_Click(object sender, EventArgs e)
        {
            PingListView.PingAll();
        }

        private void listviewComputers_MouseHover(object sender, EventArgs e)
        {
            statusLabel.Text = "Double-click a computer to connect.";
        }

        private void listviewComputers_MouseLeave(object sender, EventArgs e)
        {
            statusLabel.Text = "";
        }

        private void txtSearch_Enter(object sender, EventArgs e)
        {
            statusLabel.Text = "Type to search. Press Enter to connect to selected computer.";
        }

        private void txtSearch_Leave(object sender, EventArgs e)
        {
            statusLabel.Text = "";
        }

        private void txtSearch_MouseHover(object sender, EventArgs e)
        {
            statusLabel.Text = "Type to search. Press Enter to connect to selected computer.";
        }

        private void txtSearch_MouseLeave(object sender, EventArgs e)
        {
            statusLabel.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            GetUserName();
        }

        private void btnPing_Click(object sender, EventArgs e)
        {
            if (GetSelectedComputer().Text.Trim().Length == 0)
            {
                MessageBox.Show(this, "Please select a computer from the list to ping.", "Please select a computer", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            PingListView.PingComputer(GetSelectedComputer());
        }

        private void getUserToolStripMenuItem_Click(object sender, EventArgs e)
        {
            GetUserName();
        }

        private void GetUserName()
        {
            ListViewItem computer = GetSelectedComputer();

            if (computer.Text.Trim().Length == 0)
            {
                MessageBox.Show(this, "Please select a computer from the list to get the logged on user.", "Please select a computer", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            if (computer.SubItems.Count > 1)
            {
                if (computer.SubItems[2].Text != "True")
                {
                    MessageBox.Show(this, "Cannot obtain username because this computer is not pingable.\nPlease check that it is powered on and the firewall is off.", "Cannot obtain username", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    return;
                }
            }
            else
            {
                MessageBox.Show(this, "Cannot obtain username because this computer is not pingable.\nPlease check that it is powered on and the firewall is off.", "Cannot obtain username", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }
        
            String userName = WindowsCred.GetLoggedOnUser(GetSelectedComputer().Text);
            ListViewItem.ListViewSubItem userNameItem = new ListViewItem.ListViewSubItem(computer, userName);
            if (computer.SubItems.Count == 4)
            {
                computer.SubItems.RemoveAt(3);
            }

            computer.SubItems.Insert(3, userNameItem);
        }

        private void btnVNCDashViewer_Click(object sender, EventArgs e)
        {
            // VncSharpViewer viewer = new VncSharpViewer(GetSelectedComputer().Text);
            VncSharpViewer viewer = new VncSharpViewer("dcmain");
        }





    }
}
