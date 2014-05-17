package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import tris.Algoritmo;
 
/**
 * Basic Echo Client Socket
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class MyWebSocketHandler {
 
	private static int partitaIndex = 0;
	private static ArrayList<Partita> partite = new ArrayList<Partita>();
    private final CountDownLatch closeLatch;
 
    @SuppressWarnings("unused")
    private Session session;
 
    public MyWebSocketHandler() {
        this.closeLatch = new CountDownLatch(1);
    }
 
    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }
 
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown();
    }
 
    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.printf("Got connect: %s%n", session);
        this.session = session;
        try {
            Future<Void> fut;
            fut = session.getRemote().sendStringByFuture("Hello");
            fut.get(2, TimeUnit.SECONDS);
            fut = session.getRemote().sendStringByFuture("prova");
            session.close(StatusCode.NORMAL, "I'm done");
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("PUTTANALAMADONNA");
        }
    }
 
    @OnWebSocketMessage
    public void onMessage(String msg) {
    	
    	System.err.println("<------------ "+msg+" -------------->");
		String message = msg;

		// TODO Change StringTokenizer in XML format
		StringTokenizer s = new StringTokenizer(message, "	");

		String operazione = s.nextToken();
		PrintWriter output = new PrintWriter(new OutputStream() {
			
			@Override
			public void write(int arg0) throws IOException {
					System.err.println("Messaggio");
			}
		});
		if (operazione.equalsIgnoreCase("nuova partita")) {
			nuovaPartita(output, s);
		} else if (operazione.equalsIgnoreCase("collegati a")) {
			collegamento(output, s);
		} else if (operazione.equalsIgnoreCase("mossa")) {
			inviamossa(output, s);
		} else if(operazione.equalsIgnoreCase("update")){
			inviaAggiornamento(output,s);
		}

    }
    
    
	private static void inviamossa(PrintWriter output, StringTokenizer s) {
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					Algoritmo algoritmo = new Algoritmo();

					if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						algoritmo.execute(partite.get(i), giocatore, mossa);

					output.println(partite.get(i));

					partite.get(i).setUltimoGiocatore(giocatore);

			}

		}
	}

	private static void collegamento(PrintWriter output, StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();
		boolean partitaEsistente = false;
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)
					&& partite.get(i).getGiocatore2()
					.equalsIgnoreCase(giocatore2)
					&& partite.get(i).getRisultato().equalsIgnoreCase("inCorso")) {
					output.println(partite.get(i));

				System.out.println("Restituito a " + giocatore2
						+ " l'id della partita con " + giocatore1 + ": "
						+ partite.get(i).getId());
				partitaEsistente = true;
			}
		}	
			if (!partitaEsistente) {
				output.println("partita non esistente	" + giocatore1 + "	"
						+ giocatore2); // TODO estrai
				System.out.println("Tentata connessione a partita non esistente.");
			}
		}

	private static void nuovaPartita(PrintWriter output, StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();

		Partita partitaCreata = new Partita(partitaIndex, giocatore1,
				giocatore2);
		partite.add(partitaCreata);

		System.out.println("Iniziato una nuova partita: id=" + partitaIndex
				+ " \n" + "Giocatore1= " + giocatore1 + "\n" + "Giocatore2= "
				+ giocatore2);

		output.println(partite.get(partitaIndex));
		partitaIndex++;

	}
	private static void inviaAggiornamento(PrintWriter output,StringTokenizer s){
		int idPartita = Integer.parseInt(s.nextToken());
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					output.println(partite.get(i));
			}
		}
	}

}