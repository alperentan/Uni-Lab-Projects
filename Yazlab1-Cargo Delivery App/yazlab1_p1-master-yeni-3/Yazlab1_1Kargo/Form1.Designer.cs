
namespace Yazlab1_1Kargo
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
            this.loginPanel = new System.Windows.Forms.Panel();
            this.buttonLoginPanChangePass = new System.Windows.Forms.Button();
            this.buttonLogPanRegister = new System.Windows.Forms.Button();
            this.buttonLogPanLogin = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.loginPanUserPass = new System.Windows.Forms.TextBox();
            this.loginPanUserName = new System.Windows.Forms.TextBox();
            this.userPanel = new System.Windows.Forms.Panel();
            this.buttonUserPanCargoMap = new System.Windows.Forms.Button();
            this.buttonUserPanLogOut = new System.Windows.Forms.Button();
            this.buttonUserPanCargoTracking = new System.Windows.Forms.Button();
            this.buttonUserPanCargoCreate = new System.Windows.Forms.Button();
            this.registerPanel = new System.Windows.Forms.Panel();
            this.registerPanNewUserLocation = new System.Windows.Forms.RichTextBox();
            this.registerPanNewUserMap = new GMap.NET.WindowsForms.GMapControl();
            this.label10 = new System.Windows.Forms.Label();
            this.buttonRegisterPanCreateUser = new System.Windows.Forms.Button();
            this.buttonRegPanelBack = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.registerPanNewUserPass = new System.Windows.Forms.TextBox();
            this.registerPanNewUserName = new System.Windows.Forms.TextBox();
            this.changePassPanel = new System.Windows.Forms.Panel();
            this.label7 = new System.Windows.Forms.Label();
            this.changePassPanUserPassVerify = new System.Windows.Forms.TextBox();
            this.changePassPanChangePass = new System.Windows.Forms.Button();
            this.changePassPanBack = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.changePassPanUserNewPass = new System.Windows.Forms.TextBox();
            this.changePassPanUserName = new System.Windows.Forms.TextBox();
            this.cargoTrackingPanel = new System.Windows.Forms.Panel();
            this.buttonCargoTrackingEnableCargo = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.buttonCargoTrackingCancelCargo = new System.Windows.Forms.Button();
            this.buttonCargoTrackPanBack = new System.Windows.Forms.Button();
            this.createCargoPanel = new System.Windows.Forms.Panel();
            this.enAdress = new System.Windows.Forms.CheckBox();
            this.createCargoPanelMapPanel = new System.Windows.Forms.Panel();
            this.createCargoPanMap = new GMap.NET.WindowsForms.GMapControl();
            this.createCargoPanCustomerAdress = new System.Windows.Forms.RichTextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.createCargoPanCustomerName = new System.Windows.Forms.TextBox();
            this.buttonCreateCargoPanCargoAppend = new System.Windows.Forms.Button();
            this.buttonCreateCargoPanBack = new System.Windows.Forms.Button();
            this.loginPanel.SuspendLayout();
            this.userPanel.SuspendLayout();
            this.registerPanel.SuspendLayout();
            this.changePassPanel.SuspendLayout();
            this.cargoTrackingPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.createCargoPanel.SuspendLayout();
            this.createCargoPanelMapPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // loginPanel
            // 
            this.loginPanel.Controls.Add(this.buttonLoginPanChangePass);
            this.loginPanel.Controls.Add(this.buttonLogPanRegister);
            this.loginPanel.Controls.Add(this.buttonLogPanLogin);
            this.loginPanel.Controls.Add(this.label2);
            this.loginPanel.Controls.Add(this.label1);
            this.loginPanel.Controls.Add(this.loginPanUserPass);
            this.loginPanel.Controls.Add(this.loginPanUserName);
            this.loginPanel.Location = new System.Drawing.Point(12, 12);
            this.loginPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.loginPanel.Name = "loginPanel";
            this.loginPanel.Size = new System.Drawing.Size(452, 258);
            this.loginPanel.TabIndex = 0;
            // 
            // buttonLoginPanChangePass
            // 
            this.buttonLoginPanChangePass.Location = new System.Drawing.Point(331, 121);
            this.buttonLoginPanChangePass.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonLoginPanChangePass.Name = "buttonLoginPanChangePass";
            this.buttonLoginPanChangePass.Size = new System.Drawing.Size(101, 23);
            this.buttonLoginPanChangePass.TabIndex = 6;
            this.buttonLoginPanChangePass.Text = "Şifre Değiştir";
            this.buttonLoginPanChangePass.UseVisualStyleBackColor = true;
            this.buttonLoginPanChangePass.Click += new System.EventHandler(this.buttonLoginPanChangePass_Click);
            // 
            // buttonLogPanRegister
            // 
            this.buttonLogPanRegister.Location = new System.Drawing.Point(251, 121);
            this.buttonLogPanRegister.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonLogPanRegister.Name = "buttonLogPanRegister";
            this.buttonLogPanRegister.Size = new System.Drawing.Size(75, 23);
            this.buttonLogPanRegister.TabIndex = 5;
            this.buttonLogPanRegister.Text = "Kaydol";
            this.buttonLogPanRegister.UseVisualStyleBackColor = true;
            this.buttonLogPanRegister.Click += new System.EventHandler(this.buttonLogPanRegister_Click);
            // 
            // buttonLogPanLogin
            // 
            this.buttonLogPanLogin.Location = new System.Drawing.Point(169, 121);
            this.buttonLogPanLogin.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonLogPanLogin.Name = "buttonLogPanLogin";
            this.buttonLogPanLogin.Size = new System.Drawing.Size(75, 23);
            this.buttonLogPanLogin.TabIndex = 4;
            this.buttonLogPanLogin.Text = "Giriş Yap";
            this.buttonLogPanLogin.UseVisualStyleBackColor = true;
            this.buttonLogPanLogin.Click += new System.EventHandler(this.buttonLogPanLogin_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(123, 97);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Şifre:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(75, 69);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(88, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Kullanıcı Adı:";
            // 
            // loginPanUserPass
            // 
            this.loginPanUserPass.Location = new System.Drawing.Point(169, 92);
            this.loginPanUserPass.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.loginPanUserPass.Name = "loginPanUserPass";
            this.loginPanUserPass.Size = new System.Drawing.Size(156, 22);
            this.loginPanUserPass.TabIndex = 1;
            // 
            // loginPanUserName
            // 
            this.loginPanUserName.Location = new System.Drawing.Point(169, 64);
            this.loginPanUserName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.loginPanUserName.Name = "loginPanUserName";
            this.loginPanUserName.Size = new System.Drawing.Size(156, 22);
            this.loginPanUserName.TabIndex = 0;
            // 
            // userPanel
            // 
            this.userPanel.Controls.Add(this.buttonUserPanCargoMap);
            this.userPanel.Controls.Add(this.buttonUserPanLogOut);
            this.userPanel.Controls.Add(this.buttonUserPanCargoTracking);
            this.userPanel.Controls.Add(this.buttonUserPanCargoCreate);
            this.userPanel.Location = new System.Drawing.Point(12, 12);
            this.userPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.userPanel.Name = "userPanel";
            this.userPanel.Size = new System.Drawing.Size(116, 143);
            this.userPanel.TabIndex = 1;
            // 
            // buttonUserPanCargoMap
            // 
            this.buttonUserPanCargoMap.Location = new System.Drawing.Point(3, 71);
            this.buttonUserPanCargoMap.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonUserPanCargoMap.Name = "buttonUserPanCargoMap";
            this.buttonUserPanCargoMap.Size = new System.Drawing.Size(107, 28);
            this.buttonUserPanCargoMap.TabIndex = 4;
            this.buttonUserPanCargoMap.Text = "Araç Takip";
            this.buttonUserPanCargoMap.UseVisualStyleBackColor = true;
            this.buttonUserPanCargoMap.Click += new System.EventHandler(this.buttonUserPanCargoMap_Click);
            // 
            // buttonUserPanLogOut
            // 
            this.buttonUserPanLogOut.Location = new System.Drawing.Point(3, 105);
            this.buttonUserPanLogOut.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonUserPanLogOut.Name = "buttonUserPanLogOut";
            this.buttonUserPanLogOut.Size = new System.Drawing.Size(107, 28);
            this.buttonUserPanLogOut.TabIndex = 3;
            this.buttonUserPanLogOut.Text = "Çıkış";
            this.buttonUserPanLogOut.UseVisualStyleBackColor = true;
            this.buttonUserPanLogOut.Click += new System.EventHandler(this.buttonUserPanLogOut_Click);
            // 
            // buttonUserPanCargoTracking
            // 
            this.buttonUserPanCargoTracking.Location = new System.Drawing.Point(3, 37);
            this.buttonUserPanCargoTracking.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonUserPanCargoTracking.Name = "buttonUserPanCargoTracking";
            this.buttonUserPanCargoTracking.Size = new System.Drawing.Size(107, 28);
            this.buttonUserPanCargoTracking.TabIndex = 2;
            this.buttonUserPanCargoTracking.Text = "Kargo Takip";
            this.buttonUserPanCargoTracking.UseVisualStyleBackColor = true;
            this.buttonUserPanCargoTracking.Click += new System.EventHandler(this.buttonUserPanCargoTracking_Click);
            // 
            // buttonUserPanCargoCreate
            // 
            this.buttonUserPanCargoCreate.Location = new System.Drawing.Point(3, 2);
            this.buttonUserPanCargoCreate.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonUserPanCargoCreate.Name = "buttonUserPanCargoCreate";
            this.buttonUserPanCargoCreate.Size = new System.Drawing.Size(107, 28);
            this.buttonUserPanCargoCreate.TabIndex = 1;
            this.buttonUserPanCargoCreate.Text = "Kargo Oluştur";
            this.buttonUserPanCargoCreate.UseVisualStyleBackColor = true;
            this.buttonUserPanCargoCreate.Click += new System.EventHandler(this.buttonUserPanCargoCreate_Click);
            // 
            // registerPanel
            // 
            this.registerPanel.Controls.Add(this.registerPanNewUserLocation);
            this.registerPanel.Controls.Add(this.registerPanNewUserMap);
            this.registerPanel.Controls.Add(this.label10);
            this.registerPanel.Controls.Add(this.buttonRegisterPanCreateUser);
            this.registerPanel.Controls.Add(this.buttonRegPanelBack);
            this.registerPanel.Controls.Add(this.label3);
            this.registerPanel.Controls.Add(this.label4);
            this.registerPanel.Controls.Add(this.registerPanNewUserPass);
            this.registerPanel.Controls.Add(this.registerPanNewUserName);
            this.registerPanel.Location = new System.Drawing.Point(12, 12);
            this.registerPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.registerPanel.Name = "registerPanel";
            this.registerPanel.Size = new System.Drawing.Size(452, 426);
            this.registerPanel.TabIndex = 7;
            // 
            // registerPanNewUserLocation
            // 
            this.registerPanNewUserLocation.Location = new System.Drawing.Point(140, 80);
            this.registerPanNewUserLocation.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.registerPanNewUserLocation.Name = "registerPanNewUserLocation";
            this.registerPanNewUserLocation.Size = new System.Drawing.Size(157, 63);
            this.registerPanNewUserLocation.TabIndex = 19;
            this.registerPanNewUserLocation.Text = "";
            // 
            // registerPanNewUserMap
            // 
            this.registerPanNewUserMap.Bearing = 0F;
            this.registerPanNewUserMap.CanDragMap = true;
            this.registerPanNewUserMap.EmptyTileColor = System.Drawing.Color.Navy;
            this.registerPanNewUserMap.GrayScaleMode = false;
            this.registerPanNewUserMap.HelperLineOption = GMap.NET.WindowsForms.HelperLineOptions.DontShow;
            this.registerPanNewUserMap.LevelsKeepInMemory = 5;
            this.registerPanNewUserMap.Location = new System.Drawing.Point(61, 203);
            this.registerPanNewUserMap.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.registerPanNewUserMap.MarkersEnabled = true;
            this.registerPanNewUserMap.MaxZoom = 2;
            this.registerPanNewUserMap.MinZoom = 2;
            this.registerPanNewUserMap.MouseWheelZoomEnabled = true;
            this.registerPanNewUserMap.MouseWheelZoomType = GMap.NET.MouseWheelZoomType.MousePositionAndCenter;
            this.registerPanNewUserMap.Name = "registerPanNewUserMap";
            this.registerPanNewUserMap.NegativeMode = false;
            this.registerPanNewUserMap.PolygonsEnabled = true;
            this.registerPanNewUserMap.RetryLoadTile = 0;
            this.registerPanNewUserMap.RoutesEnabled = true;
            this.registerPanNewUserMap.ScaleMode = GMap.NET.WindowsForms.ScaleModes.Integer;
            this.registerPanNewUserMap.SelectedAreaFillColor = System.Drawing.Color.FromArgb(((int)(((byte)(33)))), ((int)(((byte)(65)))), ((int)(((byte)(105)))), ((int)(((byte)(225)))));
            this.registerPanNewUserMap.ShowTileGridLines = false;
            this.registerPanNewUserMap.Size = new System.Drawing.Size(312, 201);
            this.registerPanNewUserMap.TabIndex = 15;
            this.registerPanNewUserMap.Zoom = 0D;
            this.registerPanNewUserMap.MouseClick += new System.Windows.Forms.MouseEventHandler(this.registerPanNewUserMap_MouseClick);
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(79, 82);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(56, 17);
            this.label10.TabIndex = 14;
            this.label10.Text = "Konum:";
            // 
            // buttonRegisterPanCreateUser
            // 
            this.buttonRegisterPanCreateUser.Location = new System.Drawing.Point(221, 149);
            this.buttonRegisterPanCreateUser.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonRegisterPanCreateUser.Name = "buttonRegisterPanCreateUser";
            this.buttonRegisterPanCreateUser.Size = new System.Drawing.Size(75, 23);
            this.buttonRegisterPanCreateUser.TabIndex = 12;
            this.buttonRegisterPanCreateUser.Text = "Kaydol";
            this.buttonRegisterPanCreateUser.UseVisualStyleBackColor = true;
            this.buttonRegisterPanCreateUser.Click += new System.EventHandler(this.buttonRegisterPanCreateUser_Click);
            // 
            // buttonRegPanelBack
            // 
            this.buttonRegPanelBack.Location = new System.Drawing.Point(141, 149);
            this.buttonRegPanelBack.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonRegPanelBack.Name = "buttonRegPanelBack";
            this.buttonRegPanelBack.Size = new System.Drawing.Size(75, 23);
            this.buttonRegPanelBack.TabIndex = 11;
            this.buttonRegPanelBack.Text = "Geri";
            this.buttonRegPanelBack.UseVisualStyleBackColor = true;
            this.buttonRegPanelBack.Click += new System.EventHandler(this.buttonRegPanelBack_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(93, 57);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 17);
            this.label3.TabIndex = 10;
            this.label3.Text = "Şifre:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(47, 30);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(88, 17);
            this.label4.TabIndex = 9;
            this.label4.Text = "Kullanıcı Adı:";
            // 
            // registerPanNewUserPass
            // 
            this.registerPanNewUserPass.Location = new System.Drawing.Point(141, 52);
            this.registerPanNewUserPass.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.registerPanNewUserPass.Name = "registerPanNewUserPass";
            this.registerPanNewUserPass.Size = new System.Drawing.Size(156, 22);
            this.registerPanNewUserPass.TabIndex = 8;
            // 
            // registerPanNewUserName
            // 
            this.registerPanNewUserName.Location = new System.Drawing.Point(141, 25);
            this.registerPanNewUserName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.registerPanNewUserName.Name = "registerPanNewUserName";
            this.registerPanNewUserName.Size = new System.Drawing.Size(156, 22);
            this.registerPanNewUserName.TabIndex = 7;
            // 
            // changePassPanel
            // 
            this.changePassPanel.Controls.Add(this.label7);
            this.changePassPanel.Controls.Add(this.changePassPanUserPassVerify);
            this.changePassPanel.Controls.Add(this.changePassPanChangePass);
            this.changePassPanel.Controls.Add(this.changePassPanBack);
            this.changePassPanel.Controls.Add(this.label5);
            this.changePassPanel.Controls.Add(this.label6);
            this.changePassPanel.Controls.Add(this.changePassPanUserNewPass);
            this.changePassPanel.Controls.Add(this.changePassPanUserName);
            this.changePassPanel.Location = new System.Drawing.Point(12, 12);
            this.changePassPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanel.Name = "changePassPanel";
            this.changePassPanel.Size = new System.Drawing.Size(452, 258);
            this.changePassPanel.TabIndex = 13;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(40, 151);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(95, 17);
            this.label7.TabIndex = 14;
            this.label7.Text = "Şifre Doğrula:";
            // 
            // changePassPanUserPassVerify
            // 
            this.changePassPanUserPassVerify.Location = new System.Drawing.Point(141, 146);
            this.changePassPanUserPassVerify.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanUserPassVerify.Name = "changePassPanUserPassVerify";
            this.changePassPanUserPassVerify.Size = new System.Drawing.Size(156, 22);
            this.changePassPanUserPassVerify.TabIndex = 13;
            // 
            // changePassPanChangePass
            // 
            this.changePassPanChangePass.Location = new System.Drawing.Point(221, 175);
            this.changePassPanChangePass.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanChangePass.Name = "changePassPanChangePass";
            this.changePassPanChangePass.Size = new System.Drawing.Size(75, 23);
            this.changePassPanChangePass.TabIndex = 12;
            this.changePassPanChangePass.Text = "Değiştir";
            this.changePassPanChangePass.UseVisualStyleBackColor = true;
            this.changePassPanChangePass.Click += new System.EventHandler(this.changePassPanChangePass_Click);
            // 
            // changePassPanBack
            // 
            this.changePassPanBack.Location = new System.Drawing.Point(141, 175);
            this.changePassPanBack.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanBack.Name = "changePassPanBack";
            this.changePassPanBack.Size = new System.Drawing.Size(75, 23);
            this.changePassPanBack.TabIndex = 11;
            this.changePassPanBack.Text = "Geri";
            this.changePassPanBack.UseVisualStyleBackColor = true;
            this.changePassPanBack.Click += new System.EventHandler(this.changePassPanBack_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(61, 123);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(73, 17);
            this.label5.TabIndex = 10;
            this.label5.Text = "Yeni Şifre:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(47, 95);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(88, 17);
            this.label6.TabIndex = 9;
            this.label6.Text = "Kullanıcı Adı:";
            // 
            // changePassPanUserNewPass
            // 
            this.changePassPanUserNewPass.Location = new System.Drawing.Point(141, 118);
            this.changePassPanUserNewPass.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanUserNewPass.Name = "changePassPanUserNewPass";
            this.changePassPanUserNewPass.Size = new System.Drawing.Size(156, 22);
            this.changePassPanUserNewPass.TabIndex = 8;
            // 
            // changePassPanUserName
            // 
            this.changePassPanUserName.Location = new System.Drawing.Point(141, 90);
            this.changePassPanUserName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.changePassPanUserName.Name = "changePassPanUserName";
            this.changePassPanUserName.Size = new System.Drawing.Size(156, 22);
            this.changePassPanUserName.TabIndex = 7;
            // 
            // cargoTrackingPanel
            // 
            this.cargoTrackingPanel.Controls.Add(this.buttonCargoTrackingEnableCargo);
            this.cargoTrackingPanel.Controls.Add(this.dataGridView1);
            this.cargoTrackingPanel.Controls.Add(this.buttonCargoTrackingCancelCargo);
            this.cargoTrackingPanel.Controls.Add(this.buttonCargoTrackPanBack);
            this.cargoTrackingPanel.Location = new System.Drawing.Point(12, 12);
            this.cargoTrackingPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.cargoTrackingPanel.Name = "cargoTrackingPanel";
            this.cargoTrackingPanel.Size = new System.Drawing.Size(667, 366);
            this.cargoTrackingPanel.TabIndex = 15;
            // 
            // buttonCargoTrackingEnableCargo
            // 
            this.buttonCargoTrackingEnableCargo.Location = new System.Drawing.Point(475, 340);
            this.buttonCargoTrackingEnableCargo.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonCargoTrackingEnableCargo.Name = "buttonCargoTrackingEnableCargo";
            this.buttonCargoTrackingEnableCargo.Size = new System.Drawing.Size(109, 23);
            this.buttonCargoTrackingEnableCargo.TabIndex = 21;
            this.buttonCargoTrackingEnableCargo.Text = "Teslim Edildi";
            this.buttonCargoTrackingEnableCargo.UseVisualStyleBackColor = true;
            this.buttonCargoTrackingEnableCargo.Click += new System.EventHandler(this.buttonCargoTrackingEnableCargo_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(44, 37);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.Size = new System.Drawing.Size(576, 257);
            this.dataGridView1.TabIndex = 14;
            // 
            // buttonCargoTrackingCancelCargo
            // 
            this.buttonCargoTrackingCancelCargo.Location = new System.Drawing.Point(589, 340);
            this.buttonCargoTrackingCancelCargo.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonCargoTrackingCancelCargo.Name = "buttonCargoTrackingCancelCargo";
            this.buttonCargoTrackingCancelCargo.Size = new System.Drawing.Size(75, 23);
            this.buttonCargoTrackingCancelCargo.TabIndex = 13;
            this.buttonCargoTrackingCancelCargo.Text = "İptal Et";
            this.buttonCargoTrackingCancelCargo.UseVisualStyleBackColor = true;
            this.buttonCargoTrackingCancelCargo.Click += new System.EventHandler(this.buttonCargoTrackingCancelCargo_Click);
            // 
            // buttonCargoTrackPanBack
            // 
            this.buttonCargoTrackPanBack.Location = new System.Drawing.Point(3, 340);
            this.buttonCargoTrackPanBack.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonCargoTrackPanBack.Name = "buttonCargoTrackPanBack";
            this.buttonCargoTrackPanBack.Size = new System.Drawing.Size(75, 23);
            this.buttonCargoTrackPanBack.TabIndex = 11;
            this.buttonCargoTrackPanBack.Text = "Geri";
            this.buttonCargoTrackPanBack.UseVisualStyleBackColor = true;
            this.buttonCargoTrackPanBack.Click += new System.EventHandler(this.buttonCargoTrackPanBack_Click);
            // 
            // createCargoPanel
            // 
            this.createCargoPanel.Controls.Add(this.enAdress);
            this.createCargoPanel.Controls.Add(this.createCargoPanelMapPanel);
            this.createCargoPanel.Controls.Add(this.createCargoPanCustomerAdress);
            this.createCargoPanel.Controls.Add(this.label9);
            this.createCargoPanel.Controls.Add(this.label8);
            this.createCargoPanel.Controls.Add(this.createCargoPanCustomerName);
            this.createCargoPanel.Controls.Add(this.buttonCreateCargoPanCargoAppend);
            this.createCargoPanel.Controls.Add(this.buttonCreateCargoPanBack);
            this.createCargoPanel.Location = new System.Drawing.Point(12, 11);
            this.createCargoPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.createCargoPanel.Name = "createCargoPanel";
            this.createCargoPanel.Size = new System.Drawing.Size(900, 519);
            this.createCargoPanel.TabIndex = 16;
            // 
            // enAdress
            // 
            this.enAdress.AutoSize = true;
            this.enAdress.Checked = true;
            this.enAdress.CheckState = System.Windows.Forms.CheckState.Checked;
            this.enAdress.Location = new System.Drawing.Point(712, 251);
            this.enAdress.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.enAdress.Name = "enAdress";
            this.enAdress.Size = new System.Drawing.Size(162, 21);
            this.enAdress.TabIndex = 20;
            this.enAdress.Text = "Adres Girişini Aktif Et";
            this.enAdress.UseVisualStyleBackColor = true;
            this.enAdress.CheckedChanged += new System.EventHandler(this.enAdress_CheckedChanged);
            // 
            // createCargoPanelMapPanel
            // 
            this.createCargoPanelMapPanel.Controls.Add(this.createCargoPanMap);
            this.createCargoPanelMapPanel.Location = new System.Drawing.Point(3, 2);
            this.createCargoPanelMapPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.createCargoPanelMapPanel.Name = "createCargoPanelMapPanel";
            this.createCargoPanelMapPanel.Size = new System.Drawing.Size(459, 386);
            this.createCargoPanelMapPanel.TabIndex = 19;
            // 
            // createCargoPanMap
            // 
            this.createCargoPanMap.Bearing = 0F;
            this.createCargoPanMap.CanDragMap = true;
            this.createCargoPanMap.EmptyTileColor = System.Drawing.Color.Navy;
            this.createCargoPanMap.GrayScaleMode = false;
            this.createCargoPanMap.HelperLineOption = GMap.NET.WindowsForms.HelperLineOptions.DontShow;
            this.createCargoPanMap.LevelsKeepInMemory = 5;
            this.createCargoPanMap.Location = new System.Drawing.Point(3, 2);
            this.createCargoPanMap.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.createCargoPanMap.MarkersEnabled = true;
            this.createCargoPanMap.MaxZoom = 2;
            this.createCargoPanMap.MinZoom = 2;
            this.createCargoPanMap.MouseWheelZoomEnabled = true;
            this.createCargoPanMap.MouseWheelZoomType = GMap.NET.MouseWheelZoomType.MousePositionAndCenter;
            this.createCargoPanMap.Name = "createCargoPanMap";
            this.createCargoPanMap.NegativeMode = false;
            this.createCargoPanMap.PolygonsEnabled = true;
            this.createCargoPanMap.RetryLoadTile = 0;
            this.createCargoPanMap.RoutesEnabled = true;
            this.createCargoPanMap.ScaleMode = GMap.NET.WindowsForms.ScaleModes.Integer;
            this.createCargoPanMap.SelectedAreaFillColor = System.Drawing.Color.FromArgb(((int)(((byte)(33)))), ((int)(((byte)(65)))), ((int)(((byte)(105)))), ((int)(((byte)(225)))));
            this.createCargoPanMap.ShowTileGridLines = false;
            this.createCargoPanMap.Size = new System.Drawing.Size(452, 382);
            this.createCargoPanMap.TabIndex = 0;
            this.createCargoPanMap.Zoom = 0D;
            this.createCargoPanMap.MouseClick += new System.Windows.Forms.MouseEventHandler(this.createCargoPanMap_MouseClick);
            // 
            // createCargoPanCustomerAdress
            // 
            this.createCargoPanCustomerAdress.Location = new System.Drawing.Point(712, 74);
            this.createCargoPanCustomerAdress.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.createCargoPanCustomerAdress.Name = "createCargoPanCustomerAdress";
            this.createCargoPanCustomerAdress.Size = new System.Drawing.Size(185, 171);
            this.createCargoPanCustomerAdress.TabIndex = 18;
            this.createCargoPanCustomerAdress.Text = "";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(604, 74);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(102, 17);
            this.label9.TabIndex = 17;
            this.label9.Text = "Müşteri Adresi:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(624, 43);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(82, 17);
            this.label8.TabIndex = 15;
            this.label8.Text = "Müşteri Adı:";
            // 
            // createCargoPanCustomerName
            // 
            this.createCargoPanCustomerName.Location = new System.Drawing.Point(712, 37);
            this.createCargoPanCustomerName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.createCargoPanCustomerName.Name = "createCargoPanCustomerName";
            this.createCargoPanCustomerName.Size = new System.Drawing.Size(185, 22);
            this.createCargoPanCustomerName.TabIndex = 14;
            // 
            // buttonCreateCargoPanCargoAppend
            // 
            this.buttonCreateCargoPanCargoAppend.Location = new System.Drawing.Point(801, 2);
            this.buttonCreateCargoPanCargoAppend.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonCreateCargoPanCargoAppend.Name = "buttonCreateCargoPanCargoAppend";
            this.buttonCreateCargoPanCargoAppend.Size = new System.Drawing.Size(96, 28);
            this.buttonCreateCargoPanCargoAppend.TabIndex = 13;
            this.buttonCreateCargoPanCargoAppend.Text = "Kargo Ekle";
            this.buttonCreateCargoPanCargoAppend.UseVisualStyleBackColor = true;
            this.buttonCreateCargoPanCargoAppend.Click += new System.EventHandler(this.buttonCreateCargoPanCargoAppend_Click);
            // 
            // buttonCreateCargoPanBack
            // 
            this.buttonCreateCargoPanBack.Location = new System.Drawing.Point(3, 489);
            this.buttonCreateCargoPanBack.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.buttonCreateCargoPanBack.Name = "buttonCreateCargoPanBack";
            this.buttonCreateCargoPanBack.Size = new System.Drawing.Size(75, 27);
            this.buttonCreateCargoPanBack.TabIndex = 11;
            this.buttonCreateCargoPanBack.Text = "Geri";
            this.buttonCreateCargoPanBack.UseVisualStyleBackColor = true;
            this.buttonCreateCargoPanBack.Click += new System.EventHandler(this.buttonCreateCargoPanBack_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(915, 536);
            this.Controls.Add(this.createCargoPanel);
            this.Controls.Add(this.cargoTrackingPanel);
            this.Controls.Add(this.changePassPanel);
            this.Controls.Add(this.userPanel);
            this.Controls.Add(this.registerPanel);
            this.Controls.Add(this.loginPanel);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.loginPanel.ResumeLayout(false);
            this.loginPanel.PerformLayout();
            this.userPanel.ResumeLayout(false);
            this.registerPanel.ResumeLayout(false);
            this.registerPanel.PerformLayout();
            this.changePassPanel.ResumeLayout(false);
            this.changePassPanel.PerformLayout();
            this.cargoTrackingPanel.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.createCargoPanel.ResumeLayout(false);
            this.createCargoPanel.PerformLayout();
            this.createCargoPanelMapPanel.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel loginPanel;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox loginPanUserPass;
        private System.Windows.Forms.TextBox loginPanUserName;
        private System.Windows.Forms.Button buttonLogPanRegister;
        private System.Windows.Forms.Button buttonLogPanLogin;
        private System.Windows.Forms.Panel userPanel;
        private System.Windows.Forms.Button buttonUserPanCargoTracking;
        private System.Windows.Forms.Button buttonUserPanCargoCreate;
        private System.Windows.Forms.Button buttonLoginPanChangePass;
        private System.Windows.Forms.Button buttonUserPanLogOut;
        private System.Windows.Forms.Button buttonUserPanCargoMap;
        private System.Windows.Forms.Panel registerPanel;
        private System.Windows.Forms.Button buttonRegisterPanCreateUser;
        private System.Windows.Forms.Button buttonRegPanelBack;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox registerPanNewUserPass;
        private System.Windows.Forms.TextBox registerPanNewUserName;
        private System.Windows.Forms.Panel changePassPanel;
        private System.Windows.Forms.Button changePassPanChangePass;
        private System.Windows.Forms.Button changePassPanBack;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox changePassPanUserNewPass;
        private System.Windows.Forms.TextBox changePassPanUserName;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox changePassPanUserPassVerify;
        private System.Windows.Forms.Panel cargoTrackingPanel;
        private System.Windows.Forms.Button buttonCargoTrackPanBack;
        private System.Windows.Forms.Button buttonCargoTrackingCancelCargo;
        private System.Windows.Forms.Panel createCargoPanel;
        private System.Windows.Forms.Button buttonCreateCargoPanCargoAppend;
        private System.Windows.Forms.Button buttonCreateCargoPanBack;
        private System.Windows.Forms.RichTextBox createCargoPanCustomerAdress;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox createCargoPanCustomerName;
        private System.Windows.Forms.Panel createCargoPanelMapPanel;
        private GMap.NET.WindowsForms.GMapControl createCargoPanMap;
        private System.Windows.Forms.CheckBox enAdress;
        private System.Windows.Forms.Label label10;
        private GMap.NET.WindowsForms.GMapControl registerPanNewUserMap;
        private System.Windows.Forms.RichTextBox registerPanNewUserLocation;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button buttonCargoTrackingEnableCargo;
    }
}

