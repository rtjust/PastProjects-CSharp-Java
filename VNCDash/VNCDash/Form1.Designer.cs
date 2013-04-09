namespace VNCDash
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.btnConnect = new System.Windows.Forms.Button();
            this.btnScan = new System.Windows.Forms.Button();
            this.lblDomain = new System.Windows.Forms.Label();
            this.contextCompList = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.connectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.getUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.listviewComputers = new System.Windows.Forms.ListView();
            this.colheadCName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colheadIP = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colheadPing = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.colheadUser = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.txtSearch = new System.Windows.Forms.TextBox();
            this.lblSearch = new System.Windows.Forms.Label();
            this.btnPingAll = new System.Windows.Forms.Button();
            this.txtUser = new System.Windows.Forms.TextBox();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.btnGetUser = new System.Windows.Forms.Button();
            this.btnPing = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.statusLabel = new System.Windows.Forms.ToolStripStatusLabel();
            this.chkViewOnly = new System.Windows.Forms.CheckBox();
            this.btnVNCDashViewer = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.contextCompList.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // btnConnect
            // 
            this.btnConnect.Location = new System.Drawing.Point(515, 615);
            this.btnConnect.Name = "btnConnect";
            this.btnConnect.Size = new System.Drawing.Size(75, 23);
            this.btnConnect.TabIndex = 7;
            this.btnConnect.Text = "Connect";
            this.btnConnect.UseVisualStyleBackColor = true;
            this.btnConnect.Click += new System.EventHandler(this.btnConnect_Click);
            // 
            // btnScan
            // 
            this.btnScan.Location = new System.Drawing.Point(26, 540);
            this.btnScan.Name = "btnScan";
            this.btnScan.Size = new System.Drawing.Size(80, 23);
            this.btnScan.TabIndex = 2;
            this.btnScan.Text = "Scan Domain";
            this.btnScan.UseVisualStyleBackColor = true;
            this.btnScan.Click += new System.EventHandler(this.btnScan_Click);
            // 
            // lblDomain
            // 
            this.lblDomain.AutoSize = true;
            this.lblDomain.Location = new System.Drawing.Point(23, 60);
            this.lblDomain.Name = "lblDomain";
            this.lblDomain.Size = new System.Drawing.Size(108, 13);
            this.lblDomain.TabIndex = 3;
            this.lblDomain.Text = "Computers in domain:";
            // 
            // contextCompList
            // 
            this.contextCompList.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.connectToolStripMenuItem,
            this.pingToolStripMenuItem,
            this.getUserToolStripMenuItem});
            this.contextCompList.Name = "contextCompList";
            this.contextCompList.Size = new System.Drawing.Size(120, 70);
            // 
            // connectToolStripMenuItem
            // 
            this.connectToolStripMenuItem.Name = "connectToolStripMenuItem";
            this.connectToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.connectToolStripMenuItem.Text = "Connect";
            this.connectToolStripMenuItem.Click += new System.EventHandler(this.connectToolStripMenuItem_Click);
            // 
            // pingToolStripMenuItem
            // 
            this.pingToolStripMenuItem.Name = "pingToolStripMenuItem";
            this.pingToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.pingToolStripMenuItem.Text = "Ping";
            this.pingToolStripMenuItem.Click += new System.EventHandler(this.pingToolStripMenuItem_Click);
            // 
            // getUserToolStripMenuItem
            // 
            this.getUserToolStripMenuItem.Name = "getUserToolStripMenuItem";
            this.getUserToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.getUserToolStripMenuItem.Text = "Get User";
            this.getUserToolStripMenuItem.Click += new System.EventHandler(this.getUserToolStripMenuItem_Click);
            // 
            // listviewComputers
            // 
            this.listviewComputers.Activation = System.Windows.Forms.ItemActivation.OneClick;
            this.listviewComputers.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colheadCName,
            this.colheadIP,
            this.colheadPing,
            this.colheadUser});
            this.listviewComputers.ContextMenuStrip = this.contextCompList;
            this.listviewComputers.FullRowSelect = true;
            this.listviewComputers.GridLines = true;
            this.listviewComputers.HideSelection = false;
            this.listviewComputers.Location = new System.Drawing.Point(26, 83);
            this.listviewComputers.MultiSelect = false;
            this.listviewComputers.Name = "listviewComputers";
            this.listviewComputers.Size = new System.Drawing.Size(565, 451);
            this.listviewComputers.Sorting = System.Windows.Forms.SortOrder.Ascending;
            this.listviewComputers.TabIndex = 1;
            this.listviewComputers.UseCompatibleStateImageBehavior = false;
            this.listviewComputers.View = System.Windows.Forms.View.Details;
            this.listviewComputers.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(this.listviewComputers_MouseDoubleClick);
            this.listviewComputers.MouseLeave += new System.EventHandler(this.listviewComputers_MouseLeave);
            this.listviewComputers.MouseHover += new System.EventHandler(this.listviewComputers_MouseHover);
            // 
            // colheadCName
            // 
            this.colheadCName.Text = "Computer Name";
            this.colheadCName.Width = 166;
            // 
            // colheadIP
            // 
            this.colheadIP.Text = "IP";
            this.colheadIP.Width = 110;
            // 
            // colheadPing
            // 
            this.colheadPing.Text = "Ping";
            this.colheadPing.Width = 70;
            // 
            // colheadUser
            // 
            this.colheadUser.Text = "User";
            this.colheadUser.Width = 66;
            // 
            // txtSearch
            // 
            this.txtSearch.Location = new System.Drawing.Point(409, 57);
            this.txtSearch.Name = "txtSearch";
            this.txtSearch.Size = new System.Drawing.Size(182, 20);
            this.txtSearch.TabIndex = 0;
            this.txtSearch.TextChanged += new System.EventHandler(this.txtSearch_TextChanged);
            this.txtSearch.Enter += new System.EventHandler(this.txtSearch_Enter);
            this.txtSearch.KeyDown += new System.Windows.Forms.KeyEventHandler(this.txtSearch_KeyDown);
            this.txtSearch.Leave += new System.EventHandler(this.txtSearch_Leave);
            this.txtSearch.MouseLeave += new System.EventHandler(this.txtSearch_MouseLeave);
            this.txtSearch.MouseHover += new System.EventHandler(this.txtSearch_MouseHover);
            // 
            // lblSearch
            // 
            this.lblSearch.AutoSize = true;
            this.lblSearch.Location = new System.Drawing.Point(359, 60);
            this.lblSearch.Name = "lblSearch";
            this.lblSearch.Size = new System.Drawing.Size(44, 13);
            this.lblSearch.TabIndex = 7;
            this.lblSearch.Text = "Search:";
            // 
            // btnPingAll
            // 
            this.btnPingAll.Location = new System.Drawing.Point(161, 540);
            this.btnPingAll.Name = "btnPingAll";
            this.btnPingAll.Size = new System.Drawing.Size(53, 23);
            this.btnPingAll.TabIndex = 3;
            this.btnPingAll.Text = "Ping All";
            this.btnPingAll.UseVisualStyleBackColor = true;
            this.btnPingAll.Click += new System.EventHandler(this.btnPingAll_Click);
            // 
            // txtUser
            // 
            this.txtUser.Location = new System.Drawing.Point(491, 540);
            this.txtUser.Name = "txtUser";
            this.txtUser.Size = new System.Drawing.Size(100, 20);
            this.txtUser.TabIndex = 4;
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(491, 566);
            this.txtPass.Name = "txtPass";
            this.txtPass.PasswordChar = '*';
            this.txtPass.Size = new System.Drawing.Size(100, 20);
            this.txtPass.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(453, 545);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 13);
            this.label1.TabIndex = 13;
            this.label1.Text = "User:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(429, 569);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(56, 13);
            this.label2.TabIndex = 14;
            this.label2.Text = "Password:";
            // 
            // button1
            // 
            this.button1.Enabled = false;
            this.button1.Location = new System.Drawing.Point(424, 615);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(85, 23);
            this.button1.TabIndex = 6;
            this.button1.Text = "VNC Settings";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(217, 22);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(118, 13);
            this.label3.TabIndex = 15;
            this.label3.Text = "Alpha Test Release 0.2";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.BorderStyle = System.Windows.Forms.Border3DStyle.SunkenOuter;
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(118, 17);
            this.toolStripStatusLabel1.Text = "toolStripStatusLabel1";
            // 
            // btnGetUser
            // 
            this.btnGetUser.Location = new System.Drawing.Point(220, 540);
            this.btnGetUser.Name = "btnGetUser";
            this.btnGetUser.Size = new System.Drawing.Size(116, 23);
            this.btnGetUser.TabIndex = 16;
            this.btnGetUser.Text = "Get User of Selected";
            this.btnGetUser.UseVisualStyleBackColor = true;
            this.btnGetUser.Click += new System.EventHandler(this.button2_Click);
            // 
            // btnPing
            // 
            this.btnPing.Location = new System.Drawing.Point(112, 540);
            this.btnPing.Name = "btnPing";
            this.btnPing.Size = new System.Drawing.Size(43, 23);
            this.btnPing.TabIndex = 17;
            this.btnPing.Text = "Ping";
            this.btnPing.UseVisualStyleBackColor = true;
            this.btnPing.Click += new System.EventHandler(this.btnPing_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(23, 573);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(63, 13);
            this.label4.TabIndex = 18;
            this.label4.Text = "Computers: ";
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.statusLabel});
            this.statusStrip1.Location = new System.Drawing.Point(0, 650);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(617, 22);
            this.statusStrip1.SizingGrip = false;
            this.statusStrip1.TabIndex = 19;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // statusLabel
            // 
            this.statusLabel.Name = "statusLabel";
            this.statusLabel.Size = new System.Drawing.Size(0, 17);
            // 
            // chkViewOnly
            // 
            this.chkViewOnly.AutoSize = true;
            this.chkViewOnly.Location = new System.Drawing.Point(518, 592);
            this.chkViewOnly.Name = "chkViewOnly";
            this.chkViewOnly.Size = new System.Drawing.Size(73, 17);
            this.chkViewOnly.TabIndex = 20;
            this.chkViewOnly.Text = "View Only";
            this.chkViewOnly.UseVisualStyleBackColor = true;
            // 
            // btnVNCDashViewer
            // 
            this.btnVNCDashViewer.Location = new System.Drawing.Point(26, 615);
            this.btnVNCDashViewer.Name = "btnVNCDashViewer";
            this.btnVNCDashViewer.Size = new System.Drawing.Size(118, 23);
            this.btnVNCDashViewer.TabIndex = 21;
            this.btnVNCDashViewer.Text = "VNCDash Viewer";
            this.btnVNCDashViewer.UseVisualStyleBackColor = true;
            this.btnVNCDashViewer.Click += new System.EventHandler(this.btnVNCDashViewer_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.Control;
            this.pictureBox1.Image = global::VNCDash.Properties.Resources.vncdash1;
            this.pictureBox1.Location = new System.Drawing.Point(0, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(235, 57);
            this.pictureBox1.TabIndex = 10;
            this.pictureBox1.TabStop = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(617, 672);
            this.Controls.Add(this.chkViewOnly);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.btnVNCDashViewer);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnPing);
            this.Controls.Add(this.btnGetUser);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.txtPass);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtUser);
            this.Controls.Add(this.txtSearch);
            this.Controls.Add(this.lblDomain);
            this.Controls.Add(this.lblSearch);
            this.Controls.Add(this.listviewComputers);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnScan);
            this.Controls.Add(this.btnConnect);
            this.Controls.Add(this.btnPingAll);
            this.DoubleBuffered = true;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "VNCDash Alpha";
            this.contextCompList.ResumeLayout(false);
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnConnect;
        private System.Windows.Forms.Button btnScan;
        private System.Windows.Forms.Label lblDomain;
        private System.Windows.Forms.ContextMenuStrip contextCompList;
        private System.Windows.Forms.ToolStripMenuItem connectToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pingToolStripMenuItem;
        private System.Windows.Forms.ListView listviewComputers;
        private System.Windows.Forms.ColumnHeader colheadCName;
        private System.Windows.Forms.ColumnHeader colheadPing;
        private System.Windows.Forms.ColumnHeader colheadIP;
        private System.Windows.Forms.TextBox txtSearch;
        private System.Windows.Forms.Label lblSearch;
        private System.Windows.Forms.Button btnPingAll;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TextBox txtUser;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.Button btnGetUser;
        private System.Windows.Forms.Button btnPing;
        private System.Windows.Forms.ColumnHeader colheadUser;
        private System.Windows.Forms.ToolStripMenuItem getUserToolStripMenuItem;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel statusLabel;
        private System.Windows.Forms.CheckBox chkViewOnly;
        private System.Windows.Forms.Button btnVNCDashViewer;
    }
}

