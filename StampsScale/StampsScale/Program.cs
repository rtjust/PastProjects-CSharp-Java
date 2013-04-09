using System;
using System.Collections.Generic;
using System.Windows.Forms;
using System.IO;
using System.Reflection;
using System.Security.Principal;
using System.Runtime.InteropServices;

namespace USBScaleView
{
    static class Program
    {
        // Load managed dll from Embedded Resrouce
        static Program()
        {
            AppDomain.CurrentDomain.AssemblyResolve += new ResolveEventHandler(CurrentDomain_AssemblyResolve);
        }

        static Assembly CurrentDomain_AssemblyResolve(object sender, ResolveEventArgs args)
        {
            if (args.Name.Contains("HIDLibrary"))
            {
                // Looking for the HIDLibrary.dll assembly, load it from our own embedded resource
                foreach (string res in Assembly.GetExecutingAssembly().GetManifestResourceNames())
                {
                    if (res.EndsWith("HIDLibrary.dll"))
                    {
                        Stream s = Assembly.GetExecutingAssembly().GetManifestResourceStream(res);
                        byte[] buff = new byte[s.Length];
                        s.Read(buff, 0, buff.Length);
                        return Assembly.Load(buff);
                    }
                }
            }
            if (args.Name.Contains("AMS.Profile"))
            {
                // Looking for the AMS.Profile.dll assembly, load it from our own embedded resource
                foreach (string res in Assembly.GetExecutingAssembly().GetManifestResourceNames())
                {
                    if (res.EndsWith("AMS.Profile.dll"))
                    {
                        Stream s = Assembly.GetExecutingAssembly().GetManifestResourceStream(res);
                        byte[] buff = new byte[s.Length];
                        s.Read(buff, 0, buff.Length);
                        return Assembly.Load(buff);
                    }
                }
            }
            return null;
        } 

        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }



    }
}
