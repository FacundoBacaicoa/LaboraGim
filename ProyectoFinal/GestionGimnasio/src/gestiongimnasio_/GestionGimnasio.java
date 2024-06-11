package gestiongimnasio_;

import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.EntrenadorData;
import gestiongimnasio.DAO.MembresiaData;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;
import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GestionGimnasio {
    public static void main(String[] args) {
 //     String url = "jdbc:mysql://localhost:3306/Gimnasio";
//      String user = "root";
//       String password = "";
//
//        try (Connection con = DriverManager.getConnection(url, user, password)) {
//            SocioDAO socioDAO = new SocioDAO(con);
//
//            // Crear un nuevo socio
//            Socio nuevoSocio = new Socio(0, "12345678", "Juan", "Perez", 25, "juan@example.com", "123456789", true);
//            socioDAO.agregarSocio(nuevoSocio);
//
//            // Obtener y mostrar todos los socios
//            List<Socio> socios = socioDAO.obtenerSocios();
//            for (Socio socio : socios) {
//                System.out.println(socio);
//            }
//
//            // Actualizar un socio
//            Socio socioActualizado = socios.get(0);
//            socioActualizado.setNombre("Juan Carlos");
//            socioDAO.actualizarSocio(socioActualizado);
//
//            // Eliminar un socio
//            if (!socios.isEmpty()) {
//                int idEliminar = socios.get(0).getId_membresia();
//                socioDAO.eliminarSocio(idEliminar);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
       // ------------------------------------------------------------------------------
       
//       Entrenador entrenador = new Entrenador(2,12345672, "Lucas","Hernandez","Funcional",true);
//       EntrenadorData entData = new EntrenadorData();
//       
        // --------------------------GuardarEntrenador--------------------------
//       entData.guardarEntrenador(entrenador);
       
       // --------------------------Listar--------------------------
       // for (Entrenador entrenador1 : entData.listarEntrenadores()) {
            //System.out.println(entrenador1.getDni());
            //entData.listarEntrenadores();
      
      //--------------------------BuscarPorNombre-------------------------
      
            //  Entrenador entranadorPorNombre = entData.buscarEntrenadorPorNombre("Lucas");
        //if (entranadorPorNombre != null) {
          //  System.out.println("ID: " + entranadorPorNombre.getId_entrenadores());
           // System.out.println("Apellido: " + entranadorPorNombre.getApellido());
           // System.out.println("Nombre: " + entranadorPorNombre.getNombre());
           
           //----------------------------GuardarClase------------------------------//
           
         //ClaseData claseD = new ClaseData();

        // Ejemplo de agregar una nueva clase
//       Entrenador entrenador = new Entrenador(6,12345678, "Lucas","Hernandez","Funcional",true);
//        Clase nuevaClase = new Clase(1,"Yoga", entrenador, "18:00:00", 20, true);
//       claseD.guardarClase(nuevaClase);
            // Ejemplo de listar todas las clases
     // ArrayList<Clase> listaClases = claseD.listarClases();
//
//for (Clase clase : listaClases) {
//    System.out.println("ID Clase: " + clase.getId_clase());
//   System.out.println("Nombre: " + clase.getNombre());
//   System.out.println("Horario: " + clase.getHorario());
//   System.out.println("Capacidad: " + clase.getCapacidad());
//    System.out.println("Estado: " + clase.isEstado());
//   System.out.println();
//}
           
           
                 ClaseData claseData = new ClaseData();

        // Llamar al método `buscarClases`
        //String nombre = "Yoga"; // Nombre de la clase que deseas buscar
      //  String entrenador = "Juan Perez"; // Nombre del entrenador
      //  String horario = "10:00"; // Horario de la clase

     

        // Crear un Scanner para capturar la entrada del usuario
                ClaseData claseD = new ClaseData();

        // Llamar al método buscarClases con parámetros de prueba
        String nombreClase = "Yoga";         // Puedes cambiar estos valores para probar diferentes casos
        String nombreEntrenador = "Juan Perez"; // Puedes cambiar estos valores para probar diferentes casos
        String horario = "10:00";             // Puedes cambiar estos valores para probar diferentes casos

        List<Clase> clases = claseD.buscarClases(nombreClase, nombreEntrenador, horario);

        // Mostrar los resultados
        for (Clase clase : clases) {
            System.out.println("ID Clase: " + clase.getId_clase());
            System.out.println("Nombre Clase: " + clase.getNombre());
            System.out.println("Entrenador: " + clase.getIdEntrenador().getNombre() + " " + clase.getIdEntrenador().getApellido());
            System.out.println("Horario: " + clase.getHorario());
            System.out.println("Capacidad: " + clase.getCapacidad());
            System.out.println("Estado: " + (clase.isEstado() ? "Activo" : "Inactivo"));
            System.out.println();
        }
    }
}
   
 
      
    
           
           //-----------------------------BuscarClase-------------------------------//
          
            // Cambia los parámetros según tu configuración de la base de datos
       

            // Crear una instancia de Main y llamar al método buscarClases
           
            //List<Clase> clases = clasemetodo.buscarClases("Yoga", "Juan Perez", "18:00");

            // Imprimir los resultados
            //for (Clase clase : clases) {
             //   System.out.println("ID Clase: " + clase.getId_clase());
               // System.out.println("Nombre Clase: " + clase.getNombre());
               // System.out.println("Entrenador: " + clase.getIdEntrenador().getNombre() + " " + clase.getIdEntrenador().getApellido());
               // System.out.println("Horario: " + clase.getHorario());
               // System.out.println("Capacidad: " + clase.getCapacidad());
               // System.out.println("Estado: " + (clase.isEstado() ? "Activo" : "Inactivo"));
                //System.out.println("-----");   
                
          

//     Socio socio = new Socio();
//        socio.setId_Socio(1); // Asignar un ID válido para el socio
         // Nombre del socio (opcional, para demostración)

        // Crear una instancia de `MembresiaData`
//        MembresiaData membresiadata = new MembresiaData();

        
//        int CantidadPases = 10; // Cantidad de pases
//        int duracionMeses = 4; // Duración en meses
//
//        membresiadata.registrarMembresia(socio, CantidadPases, duracionMeses);
//        
//            Membresia membresias = new Membresia();
 //      membresias.setId_membresia(2); // Asignar un ID válido para la membresía
//        membresias.setCantidadPases(CantidadPases);
//        membresias.setFechaFin(java.sql.Date.valueOf(LocalDate.now().plusMonths(duracionMeses)));
//        membresias.setCosto(new BigDecimal("100.0")); // Asignar un costo válido para la membresía

        

      

    
       
      
        

    

