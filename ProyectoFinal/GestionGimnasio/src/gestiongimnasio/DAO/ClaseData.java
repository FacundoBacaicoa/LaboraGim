package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;
import gestiongimnasio.Entidades.Socio;
import org.mariadb.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ClaseData {

    private Connection con = null;

    public ClaseData() {
        con = Conexion.getConexion();
    }

   public void guardarClase(Clase clase) {
    String sql = "INSERT INTO clases(Nombre, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?, ?, ?, ?, ?)";
    try {
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getIdEntrenador().getId_entrenadores());
            ps.setString(3, clase.getHorario());
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                clase.setId_clase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase Guardada");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
    }
}

  public ArrayList<Clase> listarClases() {
    String sql = "SELECT ID_Clase, Nombre, ID_Entrenador, Horario, Capacidad, Estado FROM clases";
    ArrayList<Clase> clases = new ArrayList<>();
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Clase clase = new Clase();
            clase.setId_clase(rs.getInt("id_clase"));
            clase.setNombre(rs.getString("nombre"));
            clase.setHorario(rs.getString("horario"));
            clase.setCapacidad(rs.getInt("capacidad"));
            clase.setEstado(rs.getBoolean("estado"));
            clases.add(clase);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clases");
    }
    return clases;
}
    
     public List<Clase> buscarClases(String nombre, String entrenador, String horario) {
        List<Clase> clases = new ArrayList<>();
        String sql = "SELECT c.id_clase, c.nombre AS nombre_clase, e.id_entrenadores, e.nombre AS nombre_entrenador, e.apellido, c.horario, c.capacidad, c.estado " +
                     "FROM clases c " +
                     "JOIN entrenadores e ON c.id_entrenador = e.id_entrenadores " +
                     "WHERE (? IS NULL OR c.nombre LIKE ?) " +
                     "AND (? IS NULL OR CONCAT(e.nombre, ' ', e.apellido) LIKE ?) " +
                     "AND (? IS NULL OR c.horario LIKE ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, nombre == null ? null : "%" + nombre + "%");
            ps.setString(3, entrenador);
            ps.setString(4, entrenador == null ? null : "%" + entrenador + "%");
            ps.setString(5, horario);
            ps.setString(6, horario == null ? null : "%" + horario + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre_clase"));
                Entrenador entrenadorObj = new Entrenador();
                entrenadorObj.setId_entrenadores(rs.getInt("id_entrenadores"));
                entrenadorObj.setNombre(rs.getString("nombre_entrenador"));
                entrenadorObj.setApellido(rs.getString("apellido"));
                clase.setIdEntrenador(entrenadorObj);
                clase.setHorario(rs.getString("horario"));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar clases");
        }

        return clases;
    }
     
    public void inscribirSocioEnClase(Socio socio, Clase clase) {
    String sql = "INSERT INTO inscripciones (id_socio, id_clase) VALUES (?, ?)";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, socio.getId_Socio());
        ps.setInt(2, clase.getId_clase());
        
        int filasInsertadas = ps.executeUpdate();
        
        if (filasInsertadas > 0) {
            System.out.println("El socio " + socio.getNombre() + " fue inscrito correctamente en la clase " + clase.getNombre());
        } else {
            System.out.println("No se pudo inscribir al socio en la clase.");
        }
    } catch (SQLException e) {
        System.out.println("Error al inscribir al socio en la clase: " + e.getMessage());
    }
}
}
