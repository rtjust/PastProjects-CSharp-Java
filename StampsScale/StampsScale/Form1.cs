using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using System.Timers;
using AMS.Profile;

namespace USBScaleView
{

    public partial class Form1 : Form
    {
        private const String TITLE = "USB ScaleView";
        private const bool DEBUG = false;

        public Form1()
        {
            InitializeComponent();
            try
            {
                LoadProfile();
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            USBScale.InitDevice();
            this.Visible = true;          
            AutoWeigh();
        }

        private void LoadProfile()
        {
            // Load user profile information such as window position, selected units, etc
                Xml profile = new Xml();
                profile.Name = "scaleview-settings.xml";
                if (profile.HasSection("MainWindow"))
                {
                    this.Left = Convert.ToInt16(profile.GetValue("MainWindow", "Left"));
                    this.Top = Convert.ToInt16(profile.GetValue("MainWindow", "Top"));
                    radioGrams.Checked = Convert.ToBoolean(profile.GetValue("Unit", "grams"));
                    radioLboz.Checked = Convert.ToBoolean(profile.GetValue("Unit", "lb\\oz"));
                    radioOunces.Checked = Convert.ToBoolean(profile.GetValue("Unit", "ounces"));
                    chkAutoCopy.Checked = Convert.ToBoolean(profile.GetValue("Settings", "AutoCopy"));
                    chkCopyUnit.Checked = Convert.ToBoolean(profile.GetValue("Settings", "CopyUnit"));
                    chkRoundOz.Checked = Convert.ToBoolean(profile.GetValue("Settings", "RoundOz"));
                }
                else
                {
                    this.StartPosition = FormStartPosition.WindowsDefaultLocation;
                    radioGrams.Checked = false;
                    radioLboz.Checked = true;
                    radioOunces.Checked = false;
                    chkAutoCopy.Checked = false;
                    chkCopyUnit.Checked = true;
                    chkRoundOz.Checked = false;
                }

        }

        private void SaveProfile()
        {
            // Save user profile information such as window position, selected units, etc
            Xml profile = new Xml();
            profile.Name = "scaleview-settings.xml";
            profile.SetValue("Program", "Version", Application.ProductVersion);
            profile.SetValue("MainWindow", "Left", this.Left);
            profile.SetValue("MainWindow", "Top", this.Top);
            profile.SetValue("Unit", "lb\\oz", radioLboz.Checked);
            profile.SetValue("Unit", "ounces", radioOunces.Checked);
            profile.SetValue("Unit", "grams", radioGrams.Checked);
            profile.SetValue("Settings", "AutoCopy", chkAutoCopy.Checked);
            profile.SetValue("Settings", "RoundOz", chkRoundOz.Checked);
            profile.SetValue("Settings", "CopyUnit", chkCopyUnit.Checked);
        }

        private void GetWeight()
        {
            if (USBScale.IsConnected)
            {
                double ounces = 0;
                int pounds = 0;
                double grams = 0;
                double totalOunces = 0;
                USBScale.GetWeight();
                UpdateStatusBar();

                pounds = USBScale.Pounds;
                ounces = USBScale.Ounces;
                grams = USBScale.Grams;
                totalOunces = USBScale.TotalOunces;

                if (USBScale.Status == (int)(USBScale.ScaleStatus.UNDER_ZERO))
                {
                    lblDisplay.Text = "Negative weight";
                    lblDisplay.BringToFront();
                    lblDisplay.ForeColor = Color.Red;
                }
                else
                {
                    if (USBScale.Status == (int)(USBScale.ScaleStatus.OVER_WEIGHT))
                    {
                        lblLbs.ForeColor = Color.Orange;
                        lblOz.ForeColor = Color.Orange;
                        lblGrams.ForeColor = Color.Orange;
                        lblOunces.ForeColor = Color.Orange;
                    }
                    else
                    {
                        lblLbs.ForeColor = Color.Lime;
                        lblOz.ForeColor = Color.Lime;
                        lblGrams.ForeColor = Color.Lime;
                        lblOunces.ForeColor = Color.Lime;
                    }

                    if (radioGrams.Checked)
                    {
                        lblGrams.BringToFront();
                        lblGrams.Text = grams + " g";
                        UpdateTitleBar(grams);
                    }
                    else if (radioLboz.Checked)
                    {
                        lblLbs.BringToFront();
                        lblOz.BringToFront();
                        lblLbs.Text = pounds + " lb";

                        if (chkRoundOz.Checked)
                        {
                            int roundedOz = (int)(Math.Ceiling(ounces));
                            lblOz.Text = roundedOz + " oz";
                            UpdateTitleBar(pounds, roundedOz);
                        }
                        else
                        {
                            lblOz.Text = ounces + " oz";
                            UpdateTitleBar(pounds, ounces);
                        }
                    }
                    else if (radioOunces.Checked)
                    {
                        lblOunces.BringToFront();
                        lblOunces.Text = totalOunces + " oz";

                        if (chkRoundOz.Checked)
                        {
                            int roundedOz = (int)(Math.Ceiling(totalOunces));
                            lblOunces.Text = roundedOz + " oz";
                            UpdateTitleBar(0, roundedOz);
                        }
                        else
                        {
                            lblOz.Text = ounces + " oz";
                            UpdateTitleBar(0, ounces);
                        }
                    }

                }

                AutoCopy();
            }
            else
            {
                AttemptConnection();
            }
            
        }

        private void AttemptConnection()
        {
            while (!USBScale.IsConnected && Visible)
            {
                lblDisplay.BringToFront();
                lblDisplay.ForeColor = Color.Red;
                lblDisplay.Text = "Connection error...";
                UpdateStatusBar();
                if (radioLboz.Checked || radioOunces.Checked)
                {
                    UpdateTitleBar(0, 0);
                }
                else
                {
                    UpdateTitleBar(0);
                }

                USBScale.InitDevice();
                Application.DoEvents();
                Thread.Sleep(100);
            }
        }

        private void AutoWeigh()
        {
            while (Visible)
            {
                GetWeight();
                Application.DoEvents();
            }
        }

        private void UpdateStatusBar()
        {
            string statusString = "";
            if (USBScale.IsConnected)
            {
                switch (USBScale.Status)
                {
                    case (int)USBScale.ScaleStatus.FAULT:
                        statusString = "Fault, an unknown error with the scale has occurred.";
                        break;
                    case (int)USBScale.ScaleStatus.IN_MOTION:
                        statusString = "In Motion, waiting for scale to stabilize.";
                        break;
                    case (int)USBScale.ScaleStatus.NEEDS_CALIBRATE:
                        statusString = "Needs calibration, results may be inaccurate.";
                        break;
                    case (int)USBScale.ScaleStatus.NEEDS_REZERO:
                        statusString = "Needs rezeroing, results may be inaccurate.";
                        break;
                    case (int)USBScale.ScaleStatus.OVER_WEIGHT:
                        statusString = "Weight limit exceeded, results may be inaccurate.";
                        break;
                    case (int)USBScale.ScaleStatus.STABLE:
                        statusString = "Stable, results should be accurate.";
                        break;
                    case (int)USBScale.ScaleStatus.STABLE_AT_ZERO:
                        statusString = "Stable at zero.";
                        break;
                    case (int)USBScale.ScaleStatus.UNDER_ZERO:
                        statusString = "Negative weight, please rezero (tare) scale or power on\\off.";
                        break;
                    default:
                        statusString = "Uknown Status";
                        break;
                }
            }
            else
            {
                statusString = "Scale not connected. Please connect scale or power on\\off.";
            }
            toolStripStatus.Text = "Status: " + statusString;

        }

        private void lblLbs_MouseClick(object sender, MouseEventArgs e)
        {
            int pounds = USBScale.Pounds;

            if (chkCopyUnit.Checked)
            {
                Clipboard.SetText(Convert.ToString(pounds) + " lb");
            }
            else
            {
                Clipboard.SetText(Convert.ToString(pounds));
            }
        }

        private void lblOz_MouseClick(object sender, MouseEventArgs e)
        {
            double ounces = USBScale.Ounces;

            if (chkRoundOz.Checked)
            {
                ounces = Math.Ceiling(ounces);
            }

            if (chkCopyUnit.Checked)
            {
                Clipboard.SetText(Convert.ToString(ounces) + " oz");
            }
            else
            {
                Clipboard.SetText(Convert.ToString(ounces));
            }
        }

        private void lblGrams_MouseClick(object sender, MouseEventArgs e)
        {
            double grams = USBScale.Grams;

            if (chkCopyUnit.Checked)
            {
                Clipboard.SetText(Convert.ToString(grams) + " g");
            }
            else
            {
                Clipboard.SetText(Convert.ToString(grams));
            }
        }

        private void AutoCopy()
        {
            if (chkAutoCopy.Checked)
            {
                if (radioGrams.Checked)
                {
                    double grams = USBScale.Grams;
                    if (chkCopyUnit.Checked)
                    {
                        Clipboard.SetText(Convert.ToString(grams) + " g");
                    }
                    else
                    {
                        Clipboard.SetText(Convert.ToString(grams));
                    }
                }
                else if (radioOunces.Checked)
                {
                    double totalOunces = USBScale.TotalOunces;

                    if (chkRoundOz.Checked)
                    {
                        totalOunces = Math.Ceiling(totalOunces);
                    }

                    if (chkCopyUnit.Checked)
                    {
                        Clipboard.SetText(Convert.ToString(totalOunces) + " oz");
                    }
                    else
                    {
                        Clipboard.SetText(Convert.ToString(totalOunces));
                    }

                }
                else if (radioLboz.Checked)
                {
                    double ounces = USBScale.Ounces;
                    int pounds = USBScale.Pounds;

                    if (chkRoundOz.Checked)
                    {
                        ounces = Math.Ceiling(ounces);
                    }

                    if (chkCopyUnit.Checked)
                    {
                        Clipboard.SetText(Convert.ToString(pounds) + " lb " + Convert.ToString(ounces) + " oz");
                    }
                    else
                    {
                        Clipboard.SetText(Convert.ToString(pounds) + " " + Convert.ToString(ounces));
                    }
                }
            }
           // label2.Text = Clipboard.GetText();
        }

        private void UpdateTitleBar(int pounds, double ounces)
        {
            if (radioOunces.Checked)
            {
                this.Text = TITLE + " - " + ounces + " oz";
            }
            else
            {
                this.Text = TITLE + " - " + pounds + " lb " + ounces + " oz";
            }
        }

        private void UpdateTitleBar(double grams)
        {
            this.Text = TITLE + " - " + grams + " g";
        }

        private void lblOunces_Click(object sender, EventArgs e)
        {
            double totalOunces = USBScale.TotalOunces;

            if (chkRoundOz.Checked)
            {
                totalOunces = Math.Ceiling(totalOunces);
            }

            if (chkCopyUnit.Checked)
            {
                Clipboard.SetText(Convert.ToString(totalOunces) + " oz");
            }
            else
            {
                Clipboard.SetText(Convert.ToString(totalOunces));
            }
        }

        private void btnTare_Click(object sender, EventArgs e)
        {
            USBScale.TareScale();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            SaveProfile();
        }

    }
}
