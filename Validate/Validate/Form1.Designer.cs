namespace WindowsFormsApplication1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.txtUser = new System.Windows.Forms.TextBox();
            this.txtPass = new System.Windows.Forms.MaskedTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.gboxUser = new System.Windows.Forms.GroupBox();
            this.chkEnabled = new System.Windows.Forms.CheckBox();
            this.lblInitialLabel = new System.Windows.Forms.Label();
            this.lblLastLabel = new System.Windows.Forms.Label();
            this.lblFirstLabel = new System.Windows.Forms.Label();
            this.lblInitial = new System.Windows.Forms.Label();
            this.lblLastName = new System.Windows.Forms.Label();
            this.lblFirstName = new System.Windows.Forms.Label();
            this.lblMember = new System.Windows.Forms.Label();
            this.listMemberOf = new System.Windows.Forms.ListBox();
            this.gboxValidate = new System.Windows.Forms.GroupBox();
            this.btnValidate = new System.Windows.Forms.Button();
            this.lblValid = new System.Windows.Forms.Label();
            this.gboxUser.SuspendLayout();
            this.gboxValidate.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtUser
            // 
            this.txtUser.Location = new System.Drawing.Point(10, 46);
            this.txtUser.Name = "txtUser";
            this.txtUser.Size = new System.Drawing.Size(113, 22);
            this.txtUser.TabIndex = 0;
            this.txtUser.TextChanged += new System.EventHandler(this.txtUser_TextChanged);
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(127, 46);
            this.txtPass.Name = "txtPass";
            this.txtPass.PasswordChar = '*';
            this.txtPass.Size = new System.Drawing.Size(113, 22);
            this.txtPass.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(8, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(61, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Username:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(124, 30);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Password:";
            // 
            // gboxUser
            // 
            this.gboxUser.Controls.Add(this.chkEnabled);
            this.gboxUser.Controls.Add(this.lblInitialLabel);
            this.gboxUser.Controls.Add(this.lblLastLabel);
            this.gboxUser.Controls.Add(this.lblFirstLabel);
            this.gboxUser.Controls.Add(this.lblInitial);
            this.gboxUser.Controls.Add(this.lblLastName);
            this.gboxUser.Controls.Add(this.lblFirstName);
            this.gboxUser.Controls.Add(this.lblMember);
            this.gboxUser.Controls.Add(this.listMemberOf);
            this.gboxUser.Location = new System.Drawing.Point(8, 133);
            this.gboxUser.Name = "gboxUser";
            this.gboxUser.Size = new System.Drawing.Size(347, 273);
            this.gboxUser.TabIndex = 8;
            this.gboxUser.TabStop = false;
            this.gboxUser.Text = "User Summary";
            // 
            // chkEnabled
            // 
            this.chkEnabled.AutoSize = true;
            this.chkEnabled.Enabled = false;
            this.chkEnabled.Location = new System.Drawing.Point(136, 61);
            this.chkEnabled.Name = "chkEnabled";
            this.chkEnabled.Size = new System.Drawing.Size(113, 17);
            this.chkEnabled.TabIndex = 4;
            this.chkEnabled.TabStop = false;
            this.chkEnabled.Text = "Account Enabled";
            this.chkEnabled.UseVisualStyleBackColor = true;
            // 
            // lblInitialLabel
            // 
            this.lblInitialLabel.AutoSize = true;
            this.lblInitialLabel.Location = new System.Drawing.Point(114, 25);
            this.lblInitialLabel.Name = "lblInitialLabel";
            this.lblInitialLabel.Size = new System.Drawing.Size(20, 13);
            this.lblInitialLabel.TabIndex = 3;
            this.lblInitialLabel.Text = "MI";
            // 
            // lblLastLabel
            // 
            this.lblLastLabel.AutoSize = true;
            this.lblLastLabel.Location = new System.Drawing.Point(148, 25);
            this.lblLastLabel.Name = "lblLastLabel";
            this.lblLastLabel.Size = new System.Drawing.Size(62, 13);
            this.lblLastLabel.TabIndex = 3;
            this.lblLastLabel.Text = "Last Name:";
            // 
            // lblFirstLabel
            // 
            this.lblFirstLabel.AutoSize = true;
            this.lblFirstLabel.Location = new System.Drawing.Point(8, 25);
            this.lblFirstLabel.Name = "lblFirstLabel";
            this.lblFirstLabel.Size = new System.Drawing.Size(64, 13);
            this.lblFirstLabel.TabIndex = 3;
            this.lblFirstLabel.Text = "First Name:";
            // 
            // lblInitial
            // 
            this.lblInitial.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblInitial.Location = new System.Drawing.Point(117, 38);
            this.lblInitial.Name = "lblInitial";
            this.lblInitial.Size = new System.Drawing.Size(29, 20);
            this.lblInitial.TabIndex = 2;
            // 
            // lblLastName
            // 
            this.lblLastName.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblLastName.Location = new System.Drawing.Point(151, 38);
            this.lblLastName.Name = "lblLastName";
            this.lblLastName.Size = new System.Drawing.Size(100, 20);
            this.lblLastName.TabIndex = 2;
            // 
            // lblFirstName
            // 
            this.lblFirstName.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblFirstName.Location = new System.Drawing.Point(11, 38);
            this.lblFirstName.Name = "lblFirstName";
            this.lblFirstName.Size = new System.Drawing.Size(100, 20);
            this.lblFirstName.TabIndex = 2;
            // 
            // lblMember
            // 
            this.lblMember.AutoSize = true;
            this.lblMember.Location = new System.Drawing.Point(8, 71);
            this.lblMember.Name = "lblMember";
            this.lblMember.Size = new System.Drawing.Size(68, 13);
            this.lblMember.TabIndex = 1;
            this.lblMember.Text = "Member Of:";
            // 
            // listMemberOf
            // 
            this.listMemberOf.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.listMemberOf.FormattingEnabled = true;
            this.listMemberOf.Location = new System.Drawing.Point(8, 87);
            this.listMemberOf.Name = "listMemberOf";
            this.listMemberOf.Size = new System.Drawing.Size(169, 171);
            this.listMemberOf.TabIndex = 0;
            this.listMemberOf.TabStop = false;
            // 
            // gboxValidate
            // 
            this.gboxValidate.Controls.Add(this.txtPass);
            this.gboxValidate.Controls.Add(this.btnValidate);
            this.gboxValidate.Controls.Add(this.txtUser);
            this.gboxValidate.Controls.Add(this.label1);
            this.gboxValidate.Controls.Add(this.label2);
            this.gboxValidate.Controls.Add(this.lblValid);
            this.gboxValidate.Location = new System.Drawing.Point(8, 12);
            this.gboxValidate.Name = "gboxValidate";
            this.gboxValidate.Size = new System.Drawing.Size(347, 118);
            this.gboxValidate.TabIndex = 12;
            this.gboxValidate.TabStop = false;
            this.gboxValidate.Text = "Current Domain: ";
            // 
            // btnValidate
            // 
            this.btnValidate.AutoSize = true;
            this.btnValidate.Enabled = false;
            this.btnValidate.Image = global::WindowsFormsApplication1.Properties.Resources.key24;
            this.btnValidate.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnValidate.Location = new System.Drawing.Point(243, 42);
            this.btnValidate.Name = "btnValidate";
            this.btnValidate.Size = new System.Drawing.Size(92, 30);
            this.btnValidate.TabIndex = 2;
            this.btnValidate.Text = "Validate";
            this.btnValidate.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnValidate.UseVisualStyleBackColor = true;
            this.btnValidate.Click += new System.EventHandler(this.btnValidate_Click);
            // 
            // lblValid
            // 
            this.lblValid.BackColor = System.Drawing.SystemColors.Control;
            this.lblValid.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblValid.Image = global::WindowsFormsApplication1.Properties.Resources.clock24;
            this.lblValid.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.lblValid.Location = new System.Drawing.Point(10, 73);
            this.lblValid.Name = "lblValid";
            this.lblValid.Size = new System.Drawing.Size(326, 30);
            this.lblValid.TabIndex = 6;
            this.lblValid.Text = "Enter a username and optional password...";
            this.lblValid.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // Form1
            // 
            this.AcceptButton = this.btnValidate;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(361, 422);
            this.Controls.Add(this.gboxValidate);
            this.Controls.Add(this.gboxUser);
            this.Font = new System.Drawing.Font("Segoe UI", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Validate";
            this.gboxUser.ResumeLayout(false);
            this.gboxUser.PerformLayout();
            this.gboxValidate.ResumeLayout(false);
            this.gboxValidate.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnValidate;
        private System.Windows.Forms.TextBox txtUser;
        private System.Windows.Forms.MaskedTextBox txtPass;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblValid;
        private System.Windows.Forms.GroupBox gboxUser;
        private System.Windows.Forms.Label lblMember;
        private System.Windows.Forms.ListBox listMemberOf;
        private System.Windows.Forms.Label lblInitialLabel;
        private System.Windows.Forms.Label lblLastLabel;
        private System.Windows.Forms.Label lblFirstLabel;
        private System.Windows.Forms.Label lblInitial;
        private System.Windows.Forms.Label lblLastName;
        private System.Windows.Forms.Label lblFirstName;
        private System.Windows.Forms.GroupBox gboxValidate;
        private System.Windows.Forms.CheckBox chkEnabled;
    }
}

