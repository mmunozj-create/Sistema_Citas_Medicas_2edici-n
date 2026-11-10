/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_citas_medicas;

/**
 *
 * @author maria
 */
public class Cita {
    private int codigo;
    private String paciente;
    private String hora;
    private String estado;
    
    public Cita(int codigo, String paciente, String hora, String estado){
        
        this.codigo = codigo;
        this.paciente = paciente;
        this.hora = hora;
        this.estado = estado;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getPaciente(){
        return paciente;
    }
    
    public String getHora(){
        return hora;
    }
    
    public String getEstado(){
        return estado;
    }
    
    @Override
    public String toString(){
        return "Cita [Código=" + codigo + ", Paciente=" + paciente + ", Hora=" + hora + ", Estado=" + estado + "]";
    }
    
}
