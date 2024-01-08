package main;

import utilidades.Encriptacion;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(new Encriptacion().encriptar("Molly"));
        System.out.println(new Encriptacion().encriptar("Ambato"));
        System.out.println(new Encriptacion().encriptar("Genesis"));
        System.out.println(new Encriptacion().encriptar("Nano"));
        System.out.println(new Encriptacion().desencriptar("JQfyFRsn4dyzjtITR3vcJg=="));
    }
}
