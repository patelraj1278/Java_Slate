package javaconcepts.inheritance;

/**
 *
 * Java program to demonstrate Inheritance in Java programming language.
 * Inheritance is used to reuse code and Java programming language allows you
 * to either extend class or implements Interface. In this Program we have a
 * Super Class Server and a Sub Class Tomcat, which is a Server.
 * Tomcat inherit start() and stop() method of Server Super Class.
 *
 * @author Javin
 */
public class Inheritance{

    public static void main(String args[]) {
        //Super class reference variable can hold Sub Class instance
        Server server = new Tomcat();

        //we need to cast to get actual Server instance back in reference variable.
        Tomcat tomcat = (Tomcat) server;
        tomcat.start(); //starting Server

        System.out.println( "Uptime of Server in nano: " + server.uptime());

        tomcat.stop();
    }


}

class Server{
    private long uptime;

    public void start(){
        uptime = System.nanoTime();
    }

    public void stop(){
        uptime = 0;
    }

    public long uptime(){
        return uptime;
    }
}

class Tomcat extends Server{

    @Override
    public void start(){
        super.start();
        //Tomcat Server specific task
        System.out.println("Tomcat Server started");
    }

    @Override
    public void stop(){
        super.stop(); //you can call super class method using super keyword
        System.out.println("Tomcat Server Stopped");
    }
}