using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using System.Net.NetworkInformation;
using System.Net;

namespace VNCDash
{
    public static class PingListView
    {
        public static ListView ListViewToPing { get; set; }

        private static ListViewItem computerItem;

        private static ListViewItem.ListViewSubItem ipSubItem;

        private static ListViewItem.ListViewSubItem pingSubItem;

        public static void PingAll()
        {
            foreach (ListViewItem computer in ListViewToPing.Items)
            {
                computerItem = computer;
                Application.DoEvents();
                SendPing();
            }
        }

        public static void PingComputer(ListViewItem computerToPing)
        {
            if (computerToPing.Text.ToString().Trim().Length > 0)
            {
                computerItem = computerToPing;
                SendPing();
            }

        }

        private static void UpdateListView(String computerName, bool pingSuccessful, String ipAddress)
        {
            // Find computer in ListView
            ListViewItem itemToUpdate = ListViewToPing.FindItemWithText(computerName);

            // Clear current subitems, if any
            if (itemToUpdate.SubItems.Count > 1)
            {
                itemToUpdate.SubItems.RemoveAt(2);
                itemToUpdate.SubItems.RemoveAt(1);
            }

            ipSubItem = new ListViewItem.ListViewSubItem(itemToUpdate, ipAddress);
            pingSubItem = new ListViewItem.ListViewSubItem(itemToUpdate, pingSuccessful.ToString());       
            
            // Update IP column with result
            itemToUpdate.SubItems.Insert(1, ipSubItem);

            // Update Ping column with result
            itemToUpdate.SubItems.Insert(2, pingSubItem);
        }

        private static void SendPing()
        {
            AutoResetEvent waiter = new AutoResetEvent (false);

            Ping pingSender = new Ping ();

            // When the PingCompleted event is raised,
            // the PingCompletedCallback method is called.
            pingSender.PingCompleted += new PingCompletedEventHandler (PingCompletedCallback);

            // Create a buffer of 32 bytes of data to be transmitted.
            string data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            byte[] buffer = Encoding.ASCII.GetBytes (data);

            // Wait 12 seconds for a reply.
            int timeout = 120;

            // Set options for transmission:
            // The data can go through 64 gateways or routers
            // before it is destroyed, and the data packet
            // cannot be fragmented.
            PingOptions options = new PingOptions (64, true);

            // Send the ping asynchronously.
            // Use the waiter as the user token.
            // When the callback completes, it can wake up this thread.
            pingSender.SendAsync(computerItem.Text, timeout, buffer, options, waiter);
           
        }

        private static void PingCompletedCallback(object sender, PingCompletedEventArgs e)
        {
            bool pingSuccess = false;
            String fullHostName = "";
            String computerName = "";
            PingReply reply = e.Reply;

            // If the operation was canceled, exit method
            if (e.Cancelled)
            {
                // Let the main thread resume. 
                // UserToken is the AutoResetEvent object that the main thread is waiting for.
                ((AutoResetEvent)e.UserState).Set();
                return;
            }

            // If an error occurred, exit method
            if (e.Error != null)
            {
                // Let the main thread resume. 
                ((AutoResetEvent)e.UserState).Set();
                return;
            }

            // If reply is null, exit method
            if (reply == null)
            {
                // Let the main thread resume. 
                // UserToken is the AutoResetEvent object that the main thread is waitng for
                ((AutoResetEvent)e.UserState).Set();
                return;
            }
  
            // If reply is successful, set pingSuccess to true
            if (e.Reply.Status == IPStatus.Success)
            {
                pingSuccess = true;
            }

            try
            {
                fullHostName = Dns.GetHostEntry(e.Reply.Address).HostName;
            }
            catch (System.Net.Sockets.SocketException)
            {
                return; // do nothing, "The requested name is valid and was found in the database, but it does not have the correct associated data being resolved for"
            }

            if (fullHostName.Contains('.'))
            {
                computerName = fullHostName.Remove(fullHostName.IndexOf('.')).ToUpper();
            }
            else
            {
                computerName = fullHostName;
            }
            

            try
            {
                UpdateListView(computerName, pingSuccess, reply.Address.ToString());
            }
            catch (NullReferenceException)
            {
                return; // do nothing
            }

            // Let the main thread resume.
            ((AutoResetEvent)e.UserState).Set();
        }        

    }
}
