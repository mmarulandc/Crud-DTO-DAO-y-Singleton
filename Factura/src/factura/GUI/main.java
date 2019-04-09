/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.GUI;

import factura.DAO.ClienteDAO;
import factura.DAO.FacturaDAO;
import factura.DAO.ItemsDAO;
import factura.DAO.TipoItemDAO;
import factura.DTO.ClienteDTO;
import factura.DTO.FacturaDTO;
import factura.DTO.ItemsDTO;
import factura.DTO.TipoItemDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmarulandc
 */
public class main {

    public static void main(String[] args) {
        int opcion;
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese una opción  1: Agregar Factura 2: Obtener Factura  3: Actualizar Factura 4: Eliminar Factura 5: Terminar");
            opcion = entrada.nextInt();
            if (opcion == 1) {
                ClienteDAO cliente = new ClienteDAO();
                System.out.println("Datos del cliente");
                System.out.println("Nombre: ");
                String nombreCliente = entrada.next();
                System.out.println("Apellidos");
                String apellidosCliente = entrada.next();
                System.out.println("Documento");
                String documentoCliente = entrada.next();
                System.out.println("Genero");
                String generoCliente = entrada.next();
                System.out.println("Fecha de nacimiento en el siguiente formato YYYY-MM-DD");
                String fechaCliente = entrada.next();
                Date fecha = Date.valueOf(fechaCliente);
                System.out.println("Estado Civil ");
                String estadoCCliente = entrada.next();

                ClienteDTO datosCliente = new ClienteDTO(documentoCliente, nombreCliente, apellidosCliente, generoCliente, fecha, estadoCCliente);

                System.out.println("Datos del tipo de Item");
                TipoItemDAO tipoItem = new TipoItemDAO();
                System.out.println("Ingrese Id del tipo item");
                int idTipoItem = entrada.nextInt();
                System.out.println("Ingrese la descipción en una linea");
                String tipoItemDesc = entrada.next();

                System.out.println("Datos de la factura");
                System.out.println("Ingrese # de factura");
                int nroFactura = entrada.nextInt();
                Date fechaCompra = new Date(System.currentTimeMillis());
                System.out.println("La fecha de la factura es: " + fechaCompra);
                System.out.println("Ingrese el estado de la factura");
                String estadoFac = entrada.next();
                TipoItemDTO tipoItems = new TipoItemDTO(idTipoItem, tipoItemDesc);

                long totalFactura = 0;
                System.out.println("Informacion de los items a comprar");

                System.out.println("Ingrese el id del Item");
                int idItem = entrada.nextInt();
                System.out.println("Ingrese descripción en una sola linea");
                String itemDescripcion = entrada.next();
                System.out.println("Ingrese el valor por unidad");
                float valorUnidad = entrada.nextFloat();
                totalFactura += valorUnidad;

                FacturaDTO facturas = new FacturaDTO(nroFactura, fechaCompra, totalFactura, estadoFac, documentoCliente);
                ItemsDTO items = new ItemsDTO(idTipoItem, idItem, itemDescripcion, valorUnidad, facturas);
                FacturaDAO facturadao = new FacturaDAO();
                ItemsDAO itemsdao = new ItemsDAO();
                TipoItemDAO tipoitemdao = new TipoItemDAO();
                cliente.create(datosCliente);
                tipoitemdao.create(tipoItems);
                facturadao.create(facturas);
                itemsdao.create(items);

            } else if (opcion == 2) {
                System.out.println("ingrese id de la factura");
                int idFactura = entrada.nextInt();
                FacturaDAO facturadao = new FacturaDAO();
                FacturaDTO factura = facturadao.read(idFactura);
                System.out.println("Nro de la factura: " + factura.getNroFactura());
                System.out.println("Fecha  de la factura: " + factura.getFechaFactura());
                System.out.println("Cedula cliente de la factura: " + factura.getIdCliente());
                System.out.println("Total de la factura: " + factura.getTotalFactura());
                System.out.println("Estado de la factura: " + factura.getEstado());

            } else if (opcion == 3) {
                FacturaDAO facturadao = new FacturaDAO();
                System.out.println("Ingrese Id de la factura");
                int idFactura = entrada.nextInt();
                System.out.println("Igrese fecha de Factura en el formato YYYY-MM-DD");
                String fecha = entrada.next();
                Date fechaF = Date.valueOf(fecha);
                System.out.println("Ingrese cedula del cliente");
                String cedula = entrada.next();
                System.out.println("Ingrese total de la factura");
                float total = entrada.nextFloat();
                System.out.println("Ingrese estado de la factura");
                String estado = entrada.next();
                FacturaDTO facturaActualizada = new FacturaDTO(idFactura, fechaF, (long) total, estado, cedula);
                facturadao.update(facturaActualizada);

            } else if (opcion == 4) {
                FacturaDAO facturadao = new FacturaDAO();
                System.out.println("Ingrese el id de la factura a borrar");
                int idFacturaf = entrada.nextInt();
                facturadao.delete(idFacturaf);
            }

        } while (opcion != 5);

    }
}
