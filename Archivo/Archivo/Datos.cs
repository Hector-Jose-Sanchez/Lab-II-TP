using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Archivo
{
    public class Datos
    {
        public string Nombre { get; set; }
        public string Correo { get; set; }
        public string Legajo { get; set; }
        public string Carrera { get; set; }

        public Datos(string nombre, string correo, string legajo, string carrera)
        {
            Nombre = nombre;
            Correo = correo;
            Legajo = legajo;
            Carrera = carrera;
        }

        public Datos()
        {
           
        }
    }
}
