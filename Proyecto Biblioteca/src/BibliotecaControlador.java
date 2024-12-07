import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
public class BibliotecaControlador extends BibliotecaVista{
	/*
	 * Adelina Trejo Espinoza 168135
	 * Proyecto Final BIBLIOTECA CENTRAL
	 * Clase para dar funcionalidad a la ventana del usuario
	 * para trabajar con la Biblioteca
	 * 07/12/16
	 */
	
	Biblioteca mb;
	
	public BibliotecaControlador(){
		super();
		mb= new Biblioteca("Biblioteca Central", "Zapata No.450", 696950456);
		btCxT.addActionListener(new EscuchaCxTipo());
		btCxE.addActionListener(new EscuchaCxEjemplar()); 
		btvCD.addActionListener(new EscuchaEDisponibles());
		btCxC.addActionListener(new EscuchaCxClas());
		btAlta.addActionListener(new EscuchaAlta());
		btInfo.addActionListener(new EscuchaInfo());
		btBaja.addActionListener(new EscuchaBaja());
		btBuscar.addActionListener(new EscuchaBuscar()); 
		btDevolver.addActionListener(new EscuchaDevolver());
		btPrestar.addActionListener(new EscuchaPrestar());
        btLimpiar.addActionListener(new EscuchaLimpiar());
		lecturaInicial();
	}
	
	public class EscuchaAlta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String tipo, titulo, autor, editorial, clasificacion, sAnioPub, sRP;
			int anioPublicacion; 
            char estante;
            boolean restriccionPrestamo, resp;   
            
			tipo= txTip.getText();
			titulo= txTit.getText();
			autor= txAut.getText();
			sAnioPub= txAnioP.getText();
			anioPublicacion= Integer.parseInt(sAnioPub);
			editorial= txEdit.getText();
			clasificacion= txClas.getText();
			estante= txEst.getText().charAt(0);
			sRP= txRP.getText();
			restriccionPrestamo= Boolean.parseBoolean(sRP);
			
			resp=mb.altaMaterial(tipo,titulo,autor,anioPublicacion,
					editorial,clasificacion,estante,restriccionPrestamo);
			if(resp)
				taInfo.setText("alta exitosa");
			else
				taInfo.setText("alta NO exitosa");
			
		}	
	}	
	
	public void lecturaInicial(){
		Scanner lectura;
		File unArchivo;
		Biblioteca miB;
		int n, i, anioPublicacion;
		String tipo, titulo,autor, editorial, clasificacion;
		boolean resp, restriccionPrestamo;
	    char estante; 
	    
	    unArchivo=new File("info.txt");
		
		try {
			lectura= new Scanner(unArchivo);
			n= lectura.nextInt();
			for(i=1; i<=n;i++){
				tipo= lectura.next();
				titulo= lectura.next();
				autor= lectura.next();
				anioPublicacion= lectura.nextInt();
				editorial= lectura.next();
				clasificacion= lectura.next();
				estante= lectura.next().charAt(0);
				restriccionPrestamo= lectura.nextBoolean();
				
				resp=mb.altaMaterial(tipo,titulo,autor,anioPublicacion,editorial,clasificacion,estante,restriccionPrestamo);
				if(resp= true)
					System.out.println("Alta exitosa");
				else
					System.out.println("Alta NO exitosa");
			}
			
			System.out.println(mb.toString());;
			lectura.close();
				
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public class EscuchaBaja implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String sClave, infoMaterial;
			int clave;
			sClave= txClave.getText();
			clave= Integer.parseInt(sClave);
			infoMaterial= mb.bajaMaterial(clave);
			taInfo.setText(infoMaterial);			
		}	
	}
	
	public class EscuchaCxTipo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String tipo;
			int cuantos;
			tipo= txTip.getText();
			cuantos= mb.cuantosXTipo(tipo);	
			taInfo.setText("Hay "+cuantos+" materiales existentes del tipo "+tipo);			
		}		
	}
	public class EscuchaCxClas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String clasificacion;
			int cuantos;
			clasificacion= txClas.getText();
			cuantos= mb.cuantosXClasificacion(clasificacion);	
			taInfo.setText("Hay "+cuantos+" materiales existentes de la clasificacion "+clasificacion);			
		}		
	}
	
	public class EscuchaCxEjemplar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo;
			int cuantos;
			titulo= txTit.getText();
			cuantos= mb.cuantosXEjemplar(titulo);	
			taInfo.setText("Hay "+cuantos+" materiales existentes del ejemplar "+titulo);			
		}	
	}
	
	public class EscuchaEDisponibles implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo, disponibles;
			titulo= txTit.getText();
			disponibles= mb.verClaveDDisponiblesXEjemplar(titulo);	
			taInfo.setText(disponibles);			
		}		
	}
	
	public class EscuchaBuscar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String sClave, infoMaterial;
			int clave;
			sClave= txClave.getText();
			clave= Integer.parseInt(sClave);
			infoMaterial= mb.mostrarDatosDMaterial(clave);
			taInfo.setText(infoMaterial);			
		}	
	}
	
	public class EscuchaDevolver implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String sClave, sDR, devolver;
			int clave, DR;
			sClave= txClave.getText();
			clave= Integer.parseInt(sClave);
			sDR= txDR.getText();
			DR= Integer.parseInt(sDR);
			devolver= mb.devolverMaterial(clave, DR);
			taInfo.setText(devolver);			
		}	
	}
	
	public class EscuchaPrestar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String sClave, prestar;
			int clave;
			sClave= txClave.getText();
			clave= Integer.parseInt(sClave);
			prestar= mb.prestarMaterial(clave);
			taInfo.setText(prestar);			
		}	
	}
	
	public class EscuchaInfo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String info;
			info= mb.toString();
			taInfo.setText(info);
			
		}	
	}
	public class EscuchaLimpiar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			txTip.setText("");
			txTit.setText("");  
			txAut.setText("");
			txAnioP.setText("");
			txEdit.setText("");
			txClas.setText("");
			txEst.setText("");
			txRP.setText("");
			txClave.setText("");
			txDR.setText("");
			taInfo.setText("");
			
		}	
	}

}
