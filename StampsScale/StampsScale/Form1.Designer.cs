namespace USBScaleView
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
            this.lblDisplay = new System.Windows.Forms.Label();
            this.lblDebug = new System.Windows.Forms.Label();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.radioGrams = new System.Windows.Forms.RadioButton();
            this.radioLboz = new System.Windows.Forms.RadioButton();
            this.lblLbs = new System.Windows.Forms.Label();
            this.lblOz = new System.Windows.Forms.Label();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.lblGrams = new System.Windows.Forms.Label();
            this.lblOunces = new System.Windows.Forms.Label();
            this.chkCopyUnit = new System.Windows.Forms.CheckBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnTare = new System.Windows.Forms.Button();
            this.chkAutoCopy = new System.Windows.Forms.CheckBox();
            this.radioOunces = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.chkRoundOz = new System.Windows.Forms.CheckBox();
            this.statusStrip1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblDisplay
            // 
            this.lblDisplay.BackColor = System.Drawing.Color.Black;
            this.lblDisplay.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblDisplay.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblDisplay.ForeColor = System.Drawing.Color.Lime;
            this.lblDisplay.Location = new System.Drawing.Point(-2, -2);
            this.lblDisplay.Name = "lblDisplay";
            this.lblDisplay.Size = new System.Drawing.Size(455, 65);
            this.lblDisplay.TabIndex = 0;
            this.lblDisplay.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // lblDebug
            // 
            this.lblDebug.AutoSize = true;
            this.lblDebug.Location = new System.Drawing.Point(-3, 50);
            this.lblDebug.Name = "lblDebug";
            this.lblDebug.Size = new System.Drawing.Size(53, 13);
            this.lblDebug.TabIndex = 2;
            this.lblDebug.Text = "Debug: ";
            this.lblDebug.Visible = false;
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatus});
            this.statusStrip1.Location = new System.Drawing.Point(0, 198);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Padding = new System.Windows.Forms.Padding(1, 0, 16, 0);
            this.statusStrip1.Size = new System.Drawing.Size(450, 22);
            this.statusStrip1.SizingGrip = false;
            this.statusStrip1.TabIndex = 8;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatus
            // 
            this.toolStripStatus.Font = new System.Drawing.Font("Verdana", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.toolStripStatus.Name = "toolStripStatus";
            this.toolStripStatus.Size = new System.Drawing.Size(433, 17);
            this.toolStripStatus.Spring = true;
            this.toolStripStatus.Text = "Status:";
            this.toolStripStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // radioGrams
            // 
            this.radioGrams.AutoSize = true;
            this.radioGrams.Font = new System.Drawing.Font("Verdana", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.radioGrams.Location = new System.Drawing.Point(362, 90);
            this.radioGrams.Name = "radioGrams";
            this.radioGrams.Size = new System.Drawing.Size(61, 17);
            this.radioGrams.TabIndex = 6;
            this.radioGrams.Text = "grams";
            this.radioGrams.UseVisualStyleBackColor = true;
            // 
            // radioLboz
            // 
            this.radioLboz.AutoSize = true;
            this.radioLboz.Font = new System.Drawing.Font("Verdana", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.radioLboz.Location = new System.Drawing.Point(362, 44);
            this.radioLboz.Name = "radioLboz";
            this.radioLboz.Size = new System.Drawing.Size(53, 17);
            this.radioLboz.TabIndex = 4;
            this.radioLboz.Text = "lb\\oz";
            this.radioLboz.UseVisualStyleBackColor = true;
            // 
            // lblLbs
            // 
            this.lblLbs.BackColor = System.Drawing.Color.Black;
            this.lblLbs.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblLbs.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblLbs.ForeColor = System.Drawing.Color.Lime;
            this.lblLbs.Location = new System.Drawing.Point(0, -3);
            this.lblLbs.Name = "lblLbs";
            this.lblLbs.Size = new System.Drawing.Size(225, 66);
            this.lblLbs.TabIndex = 0;
            this.lblLbs.Text = "0 lb";
            this.lblLbs.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.toolTip1.SetToolTip(this.lblLbs, "Click to copy lb to clipboard.");
            this.lblLbs.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lblLbs_MouseClick);
            // 
            // lblOz
            // 
            this.lblOz.BackColor = System.Drawing.Color.Black;
            this.lblOz.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblOz.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblOz.ForeColor = System.Drawing.Color.Lime;
            this.lblOz.Location = new System.Drawing.Point(225, -3);
            this.lblOz.Name = "lblOz";
            this.lblOz.Size = new System.Drawing.Size(225, 66);
            this.lblOz.TabIndex = 0;
            this.lblOz.Text = "0 oz";
            this.lblOz.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.toolTip1.SetToolTip(this.lblOz, "Click to copy oz to clipboard.");
            this.lblOz.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lblOz_MouseClick);
            // 
            // toolTip1
            // 
            this.toolTip1.ToolTipIcon = System.Windows.Forms.ToolTipIcon.Info;
            this.toolTip1.ToolTipTitle = "Copy";
            // 
            // lblGrams
            // 
            this.lblGrams.BackColor = System.Drawing.Color.Black;
            this.lblGrams.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblGrams.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblGrams.ForeColor = System.Drawing.Color.Lime;
            this.lblGrams.Location = new System.Drawing.Point(0, -3);
            this.lblGrams.Name = "lblGrams";
            this.lblGrams.Size = new System.Drawing.Size(450, 66);
            this.lblGrams.TabIndex = 16;
            this.lblGrams.Text = "0 g";
            this.lblGrams.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.toolTip1.SetToolTip(this.lblGrams, "Click to copy grams to clipboard.");
            this.lblGrams.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lblGrams_MouseClick);
            // 
            // lblOunces
            // 
            this.lblOunces.BackColor = System.Drawing.Color.Black;
            this.lblOunces.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblOunces.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblOunces.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblOunces.ForeColor = System.Drawing.Color.Lime;
            this.lblOunces.Location = new System.Drawing.Point(-2, -1);
            this.lblOunces.Name = "lblOunces";
            this.lblOunces.Size = new System.Drawing.Size(455, 65);
            this.lblOunces.TabIndex = 20;
            this.lblOunces.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.toolTip1.SetToolTip(this.lblOunces, "Click to copy ounces to the clipboard.");
            this.lblOunces.Click += new System.EventHandler(this.lblOunces_Click);
            // 
            // chkCopyUnit
            // 
            this.chkCopyUnit.AutoSize = true;
            this.chkCopyUnit.Checked = true;
            this.chkCopyUnit.CheckState = System.Windows.Forms.CheckState.Checked;
            this.chkCopyUnit.Font = new System.Drawing.Font("Verdana", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.chkCopyUnit.Location = new System.Drawing.Point(12, 68);
            this.chkCopyUnit.Name = "chkCopyUnit";
            this.chkCopyUnit.Size = new System.Drawing.Size(175, 17);
            this.chkCopyUnit.TabIndex = 3;
            this.chkCopyUnit.Text = "Include unit when copying";
            this.chkCopyUnit.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnTare);
            this.groupBox1.Controls.Add(this.chkAutoCopy);
            this.groupBox1.Controls.Add(this.radioOunces);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.chkRoundOz);
            this.groupBox1.Controls.Add(this.radioLboz);
            this.groupBox1.Controls.Add(this.radioGrams);
            this.groupBox1.Controls.Add(this.chkCopyUnit);
            this.groupBox1.Location = new System.Drawing.Point(7, 66);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(434, 123);
            this.groupBox1.TabIndex = 19;
            this.groupBox1.TabStop = false;
            // 
            // btnTare
            // 
            this.btnTare.Location = new System.Drawing.Point(12, 91);
            this.btnTare.Name = "btnTare";
            this.btnTare.Size = new System.Drawing.Size(109, 23);
            this.btnTare.TabIndex = 24;
            this.btnTare.Text = "Tare (Rezero)";
            this.btnTare.UseVisualStyleBackColor = true;
            this.btnTare.Click += new System.EventHandler(this.btnTare_Click);
            // 
            // chkAutoCopy
            // 
            this.chkAutoCopy.AutoSize = true;
            this.chkAutoCopy.Location = new System.Drawing.Point(12, 45);
            this.chkAutoCopy.Name = "chkAutoCopy";
            this.chkAutoCopy.Size = new System.Drawing.Size(172, 17);
            this.chkAutoCopy.TabIndex = 2;
            this.chkAutoCopy.Text = "Automatically copy to clipboard";
            this.chkAutoCopy.UseVisualStyleBackColor = true;
            // 
            // radioOunces
            // 
            this.radioOunces.AutoSize = true;
            this.radioOunces.Location = new System.Drawing.Point(362, 67);
            this.radioOunces.Name = "radioOunces";
            this.radioOunces.Size = new System.Drawing.Size(60, 17);
            this.radioOunces.TabIndex = 5;
            this.radioOunces.Text = "ounces";
            this.radioOunces.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(359, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 13);
            this.label1.TabIndex = 20;
            this.label1.Text = "Unit:";
            // 
            // chkRoundOz
            // 
            this.chkRoundOz.AutoSize = true;
            this.chkRoundOz.Location = new System.Drawing.Point(12, 21);
            this.chkRoundOz.Name = "chkRoundOz";
            this.chkRoundOz.Size = new System.Drawing.Size(232, 17);
            this.chkRoundOz.TabIndex = 1;
            this.chkRoundOz.Text = "Round up to nearest ounce (USPS method)";
            this.chkRoundOz.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(450, 220);
            this.Controls.Add(this.lblOunces);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.lblDisplay);
            this.Controls.Add(this.lblOz);
            this.Controls.Add(this.lblLbs);
            this.Controls.Add(this.lblGrams);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.lblDebug);
            this.DoubleBuffered = true;
            this.Font = new System.Drawing.Font("Verdana", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "USB ScaleView";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblDebug;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.Label lblDisplay;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatus;
        private System.Windows.Forms.RadioButton radioGrams;
        private System.Windows.Forms.RadioButton radioLboz;
        private System.Windows.Forms.Label lblLbs;
        private System.Windows.Forms.Label lblOz;
        private System.Windows.Forms.ToolTip toolTip1;
        private System.Windows.Forms.Label lblGrams;
        private System.Windows.Forms.CheckBox chkCopyUnit;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.CheckBox chkRoundOz;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox chkAutoCopy;
        private System.Windows.Forms.RadioButton radioOunces;
        private System.Windows.Forms.Label lblOunces;
        private System.Windows.Forms.Button btnTare;

    }
}

