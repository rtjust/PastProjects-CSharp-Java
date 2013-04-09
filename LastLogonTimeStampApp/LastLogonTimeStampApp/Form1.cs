using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace LastLogonTimeStampApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
            String[,] computerAndTimeStamp = WindowsCred.EnumerateComputersAndLastLogonTimeStamp();

            for (int i = 0; i < computerAndTimeStamp.GetLength(0) - 1; i++)
            {
                listView1.Items.Add(new ListViewItem(computerAndTimeStamp[i,0]));
                listView1.Items[i].SubItems.Add(new ListViewItem.ListViewSubItem(listView1.Items[i], computerAndTimeStamp[i,1]));
            }

            label1.Text = "Count: " + listView1.Items.Count;
            
        }

        private void listView1_Click(object sender, EventArgs e)
        {
            Clipboard.SetText(listView1.SelectedItems[0].Text);
        }


    }
}
