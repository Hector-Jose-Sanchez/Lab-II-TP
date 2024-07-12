namespace Archivo
{
    partial class Nuevo
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
            this.textBoxname = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.buttonagregar = new System.Windows.Forms.Button();
            this.textBoxcorreo = new System.Windows.Forms.TextBox();
            this.textBoxlegajo = new System.Windows.Forms.TextBox();
            this.textBoxcarrera = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // textBoxname
            // 
            this.textBoxname.Location = new System.Drawing.Point(62, 13);
            this.textBoxname.Name = "textBoxname";
            this.textBoxname.Size = new System.Drawing.Size(206, 20);
            this.textBoxname.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Nombre";
            // 
            // buttonagregar
            // 
            this.buttonagregar.Location = new System.Drawing.Point(113, 126);
            this.buttonagregar.Name = "buttonagregar";
            this.buttonagregar.Size = new System.Drawing.Size(75, 23);
            this.buttonagregar.TabIndex = 2;
            this.buttonagregar.Text = "Agregar";
            this.buttonagregar.UseVisualStyleBackColor = true;
            this.buttonagregar.Click += new System.EventHandler(this.buttonagregar_Click);
            // 
            // textBoxcorreo
            // 
            this.textBoxcorreo.Location = new System.Drawing.Point(62, 39);
            this.textBoxcorreo.Name = "textBoxcorreo";
            this.textBoxcorreo.Size = new System.Drawing.Size(206, 20);
            this.textBoxcorreo.TabIndex = 3;
            // 
            // textBoxlegajo
            // 
            this.textBoxlegajo.Location = new System.Drawing.Point(62, 65);
            this.textBoxlegajo.Name = "textBoxlegajo";
            this.textBoxlegajo.Size = new System.Drawing.Size(206, 20);
            this.textBoxlegajo.TabIndex = 4;
            // 
            // textBoxcarrera
            // 
            this.textBoxcarrera.Location = new System.Drawing.Point(62, 91);
            this.textBoxcarrera.Name = "textBoxcarrera";
            this.textBoxcarrera.Size = new System.Drawing.Size(206, 20);
            this.textBoxcarrera.TabIndex = 5;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 46);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(38, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "Correo";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 68);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(39, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "Legajo";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 94);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(41, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "Carrera";
            // 
            // Nuevo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(322, 198);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBoxcarrera);
            this.Controls.Add(this.textBoxlegajo);
            this.Controls.Add(this.textBoxcorreo);
            this.Controls.Add(this.buttonagregar);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBoxname);
            this.Name = "Nuevo";
            this.Text = "Nuevo";
            this.Load += new System.EventHandler(this.Nuevo_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxname;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonagregar;
        private System.Windows.Forms.TextBox textBoxcorreo;
        private System.Windows.Forms.TextBox textBoxlegajo;
        private System.Windows.Forms.TextBox textBoxcarrera;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
    }
}