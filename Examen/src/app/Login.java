package app;

import objimp.ProductoDaoImp;

public class Login {
	public static void main(String[] args) {
		ProductoDaoImp proimp = new ProductoDaoImp("root", "");
		proimp.probarConexion();
	}	
}
