using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Diagnostics;
using System.IO;
using System.Reflection;
using System.Security.Principal;

namespace GISD_Authenticator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            // If CheckStatus returns false (process not running) try to start the process
            if (!CheckStatus())
            {
                // If process fails to start then display error otherwise display success
                if (!StartAuth())
                {
                    SetStatus("Unable to start process. See log for details.", false);
                }
                else
                {
                    SetStatus("Process started successfully.", true);
                }
                
            }

            LogMsg("");
            LogMsg("Click the OK button to exit this window. The process will continue to run in the background if it started successfully.");
            
        }

        private void SetStatus(String msgText, bool isGreen)
        {
            // Method to change lblStatus text, color, and image
            if (isGreen)
            {
                lblStatus.Image = GISD_Authenticator.Properties.Resources.accept24;
                lblStatus.BackColor = Color.Green;
            }
            else
            { 
                lblStatus.Image = GISD_Authenticator.Properties.Resources.delete24;
                lblStatus.BackColor = Color.Red;
            }

                lblStatus.Text = "Status: " + msgText;
        }

        private bool CheckStatus()
        {
            // Method to determine prcoess running status

            if (Process.GetProcessesByName("authenticat").Length > 0)
            {
                SetStatus("Process is already running.", true);
                return true;
            }
            else
            {
                SetStatus("Process is not running.", false);
                return false;
            }

        }

        /* Used to search for and kill the process. Returns true if kill succeeds.
        private bool KillAuth()
        {
            foreach (Process p in Process.GetProcessesByName("authenticat"))
            {
                try
                {
                    LogMsg("Process is already started, restarting process ...");
                    p.Kill();
                    p.WaitForExit(); // possibly with a timeout
                    return true;
                }
                catch (Win32Exception winException)
                {
                    // process was terminating or can't be terminated - deal with it
                    return false;
                }
                catch (InvalidOperationException invalidException)
                {
                    // process has already exited - might be able to let this one go
                    return false;
                }
               
            }
            return false;
        }
         */

        private bool StartAuth()
        {
            const string resName = "GISD_Authenticator.authenticator.exe";
            String tempPath = Convert.ToString(System.IO.Path.GetTempPath());
            String fileName =  tempPath + "authenticat.exe";

            Assembly myAssembly = Assembly.GetExecutingAssembly();
            byte[] buffer = new byte[0];

            // Read resource into memory
            using (Stream s = myAssembly.GetManifestResourceStream(resName))
            {
                buffer = new byte[s.Length];
                s.Read(buffer, 0, buffer.Length);
            }

            // Write resource to disk
            try
            {
                LogMsg("Extracting 'authenticat.exe' to temporary path '" + tempPath + "'");
                using (Stream s = File.Create(fileName))
                {
                    s.Write(buffer, 0, buffer.Length);
                }
               
            } 
            catch(UnauthorizedAccessException e)
            {
                LogMsg("There was a problem creating the file at '" + tempPath + "'");
                return false;
                //LogMsg("ERROR: " + Convert.ToString(e)); 
            }
            catch (Exception e)
            {
                LogMsg("There was a problem creating the file at '" + tempPath + "'");
                return false;
                //LogMsg("ERROR: " + Convert.ToString(e));
            }

            
            // Start the file
            try
            { 
                LogMsg("Attempting to start process 'authenticat.exe'");
                ProcessStartInfo processInfo = new ProcessStartInfo();
               // processInfo.Verb = "runas";
                processInfo.FileName = fileName;
                processInfo.Arguments = "RA[198.110.24.94]";
                Process.Start(processInfo);
                LogMsg("Process started successfully as 'authenticat.exe RA[198.110.24.94]'");
                return true;
            }
            catch (Exception e)
            {
                LogMsg("There was a problem starting the process at '" + fileName +"'");
                return false;
                // LogMsg("ERROR: " + Convert.ToString(e));
            }

        }

        private void LogMsg(String inputLine)
        {
            if (String.IsNullOrEmpty(txtLog.Text))
                txtLog.Text = inputLine;
            else
                txtLog.Text += Environment.NewLine + inputLine;

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            String strVersion = System.Reflection.Assembly.GetExecutingAssembly().GetName().Version.ToString();
            lblVersion.Text += strVersion;
        }

    }
}
