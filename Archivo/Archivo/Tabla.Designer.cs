namespace Archivo
{
    partial class Tabla
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.buttonmas = new System.Windows.Forms.Button();
            this.buttonsafe = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(12, 34);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(571, 242);
            this.dataGridView1.TabIndex = 0;
            // 
            // buttonmas
            // 
            this.buttonmas.Location = new System.Drawing.Point(22, 300);
            this.buttonmas.Name = "buttonmas";
            this.buttonmas.Size = new System.Drawing.Size(75, 23);
            this.buttonmas.TabIndex = 1;
            this.buttonmas.Text = "Agregar";
            this.buttonmas.UseVisualStyleBackColor = true;
            this.buttonmas.Click += new System.EventHandler(this.buttonmas_Click);
            // 
            // buttonsafe
            // 
            this.buttonsafe.Location = new System.Drawing.Point(128, 300);
            this.buttonsafe.Name = "buttonsafe";
            this.buttonsafe.Size = new System.Drawing.Size(75, 23);
            this.buttonsafe.TabIndex = 2;
            this.buttonsafe.Text = "Gurdar";
            this.buttonsafe.UseVisualStyleBackColor = true;
            this.buttonsafe.Click += new System.EventHandler(this.buttonsafe_Click);
            // 
            // Tabla
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(598, 335);
            this.Controls.Add(this.buttonsafe);
            this.Controls.Add(this.buttonmas);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Tabla";
            this.Text = "Tabla";
            this.Load += new System.EventHandler(this.Tabla_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button buttonmas;
        private System.Windows.Forms.Button buttonsafe;
    }
}