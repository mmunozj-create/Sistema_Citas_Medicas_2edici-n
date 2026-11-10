/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.sistema_de_citas_medicas;

/**
 *
 * @author maria
 */
public class SistemaCitas {
    
    public static class ResultadoBusqueda {
        public int indice;
        public int comparaciones;

        public ResultadoBusqueda(int indice, int comparaciones) {
            this.indice = indice;
            this.comparaciones = comparaciones;
        }
    }

    // Búsqueda lineal por código
    public static ResultadoBusqueda busquedaLineal(Cita[] arreglo, int codigoBuscado) {
        int comparaciones = 0;
        for (int i = 0; i < arreglo.length; i++) {
            comparaciones++;
            if (arreglo[i].getCodigo() == codigoBuscado) {
                return new ResultadoBusqueda(i, comparaciones);
            }
        }
        return new ResultadoBusqueda(-1, comparaciones);
    }

    // Buscar todas las citas de un paciente
    public static Cita[] buscarCitasPorPaciente(Cita[] arreglo, String nombrePaciente) {
        int contador = 0; // Corregido: 'contador' en minúscula
        for (Cita c : arreglo) {
            if (c.getPaciente().equalsIgnoreCase(nombrePaciente)) {
                contador++;
            }
        }

        Cita[] resultados = new Cita[contador];
        int idx = 0;
        for (Cita c : arreglo) {
            if (c.getPaciente().equalsIgnoreCase(nombrePaciente)) { // Corregido: equalsIgnoreCase
                resultados[idx++] = c;
            }
        }
        return resultados;
    }

    // Ordenamiento burbuja por código
    public static void ordenarPorCodigo(Cita[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arreglo[j].getCodigo() > arreglo[j + 1].getCodigo()) {
                    Cita temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Búsqueda binaria por código
    public static ResultadoBusqueda busquedaBinaria(Cita[] arreglo, int codigoBuscado) {
        int lo = 0;
        int hi = arreglo.length - 1;
        int comparaciones = 0;

        while (lo <= hi) {
            comparaciones++;
            int mid = lo + ((hi - lo) >>> 1);

            if (arreglo[mid].getCodigo() == codigoBuscado) {
                return new ResultadoBusqueda(mid, comparaciones);
            }

            comparaciones++;
            if (arreglo[mid].getCodigo() < codigoBuscado) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new ResultadoBusqueda(-1, comparaciones);
    }

    // Método main
    public static void main(String[] args) {
        Cita[] citas = {
            new Cita(105, "Carlos Pérez", "08:00 AM", "Programada"),
            new Cita(101, "María Gómez", "09:30 AM", "Atendida"),
            new Cita(108, "Carlos Pérez", "10:15 AM", "Programada"),
            new Cita(103, "Ana Rodríguez", "11:00 AM", "Cancelada"),
            new Cita(109, "Luis Torres", "02:00 PM", "Programada"),
            new Cita(102, "Sofía Castro", "03:30 PM", "Atendida")
        };

        System.out.println("=== 1. ARREGLO INICIAL (DESORDENADO) ===");
        for (Cita c : citas) {
            System.out.println(c);
        }

        // Búsqueda lineal
        int codigoBuscado = 103;
        System.out.println("\n=== 2. BÚSQUEDA LINEAL (Código: " + codigoBuscado + ") ===");
        ResultadoBusqueda resLineal = busquedaLineal(citas, codigoBuscado);
        if (resLineal.indice != -1) {
            System.out.println("¡Encontrado! Posición: " + resLineal.indice);
            System.out.println("Detalles: " + citas[resLineal.indice]);
        } else {
            System.out.println("El código " + codigoBuscado + " no existe.");
        }
        System.out.println("Operaciones (comparaciones) realizadas: " + resLineal.comparaciones);

        // Búsqueda por paciente
        String pacienteBuscado = "Carlos Pérez";
        System.out.println("\n=== 3. BÚSQUEDA DE TODAS LAS CITAS DEL PACIENTE: " + pacienteBuscado + " ===");
        Cita[] citasPaciente = buscarCitasPorPaciente(citas, pacienteBuscado);
        if (citasPaciente.length > 0) {
            for (Cita c : citasPaciente) {
                System.out.println(c);
            }
        } else {
            System.out.println("No se encontraron citas para ese paciente.");
        }

        // Ordenamiento por código
        ordenarPorCodigo(citas);
        System.out.println("\n=== 4. ARREGLO ORDENADO POR CÓDIGO ===");
        for (Cita c : citas) {
            System.out.println(c);
        }

        // Búsqueda binaria
        int codigoBinario = 103;
        System.out.println("\n=== 5. BÚSQUEDA BINARIA (Código: " + codigoBinario + ") ===");
        ResultadoBusqueda resBinaria = busquedaBinaria(citas, codigoBinario);
        if (resBinaria.indice != -1) {
            System.out.println("¡Encontrado! Posición en arreglo ordenado: " + resBinaria.indice);
            System.out.println("Detalles: " + citas[resBinaria.indice]);
        } else {
            System.out.println("El código " + codigoBinario + " no existe.");
        }
        System.out.println("Operaciones (comparaciones) realizadas: " + resBinaria.comparaciones);

        // Comparación de operaciones
        System.out.println("\n=== 6. COMPARACIÓN DE RENDIMIENTO / OPERACIONES ===");
        int codigoObjetivo = 109;
        ResultadoBusqueda cmpL = busquedaLineal(citas, codigoObjetivo);   // Corregido: ResultadoBusqueda
        ResultadoBusqueda cmpB = busquedaBinaria(citas, codigoObjetivo);  // Corregido: ResultadoBusqueda
        System.out.println("Buscando código " + codigoObjetivo + ":");
        System.out.println("- Comparaciones Búsqueda Lineal: " + cmpL.comparaciones);
        System.out.println("- Comparaciones Búsqueda Binaria: " + cmpB.comparaciones);
    }
}
