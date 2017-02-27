package RecomanderSystems;

import java.util.Random;

public class Matran {
	private  static int m;
	private  static int n;
	public float[][] randomMatran (int m ,int n){
		Random rd = new Random();
		float matran[][] = new float[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matran[i][j] = rd.nextInt(4)-4;
				System.out.print(matran[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("====================================");
		return matran;
	}
	public float findFrobenius(float A[][], int m, int n){
		float frobenius=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				frobenius+= A[i][j]*A[i][j];
			}
		}
		return frobenius;
	}
	public float timchuan(float w[][],float h[][],float Dtrain[][]){
		float delta = 0.01f;
		float Omf = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				float Rui = Dtrain[i][j];
				float Rui2 = 0;
				for(int k=0;k<2;k++){
					Rui2 += w[i][k]*h[k][j];
				}
				Omf+= Math.pow(Rui-Rui2, 2)+(delta*(findFrobenius(w, m, 2)+findFrobenius(h, 2, n))); 
			}
		}
		return Omf;
	}
	public Matran(int m, int n){
		this.m = m;
		this.n= n;
	}
	public void phanRaMT(float w[][],float h[][], float Dtrain[][], float DTest[][]){
		float chuan = timchuan(w, h, Dtrain);
		float delta = 0.01f;
		float beta = 0.001f;
		float wNew = 0f;
		float hNew = 0f;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				//w[i][j] = rd.nextInt(2);
				System.out.print(w[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("====================================");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(h[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("====================================");
		int sl = 0;
		while(chuan > 1000){
			/*for(int i=0;i<m;i++){
				for(int j=0;i<n;j++){
					float Rui2 = 0f;
					for(int k=0;k<2;k++){
						Rui2 += w[i][k]*h[k][j];
						wNew += w[i][k] + beta*(2*(Dtrain[i][j]-Rui2)*h[k][j]-delta*w[i][k]);
						hNew += h[i][k] + beta*(2*(Dtrain[i][j]-Rui2)*w[i][k]-delta*h[k][j]);
					}
					
				}
			}*/
			for(int i=0;i<m;i++){
				for(int k=0;k<2;k++){
					float Rui2 = 0.0f;
					for(int q=0;q<2;q++){
						Rui2 += w[i][q]*h[q][0];//i = 0 : vi tri dau tien
					}
					//w[i][k] += beta*(2*(Dtrain[i][0]-Rui2)*h[k][0] - delta*(w[i][k]));
					  w[i][k] = w[i][k] + beta*(2*(Dtrain[i][0]-Rui2)*h[k][0])-delta*w[i][k];
					//System.out.println(w[i][k] +"\t");
					//w[i][k] = wNew;
				}
			}
			for(int k=0;k<2;k++){
				for(int j=0;j<n;j++){
					float Rui2 = 0.0f;
					for(int q=0;q<2;q++){
						Rui2 += w[0][q]*h[q][j];//i = 0 : vi tri dau tien
					}
				  h[k][j] = h[k][j]+beta*(2*(Dtrain[0][j]-Rui2)*w[0][k])-delta*h[k][j];
					//h[k][j]+= beta*(2*(Dtrain[0][j]-Rui2)*w[0][k] - delta*(h[k][j])); 
				//	System.out.println(h[k][j]);
					//h[k][j] = hNew;
				}
			}
			chuan = timchuan(w, h, Dtrain);
			sl++;
			System.out.println(chuan);
		}
		//System.out.println(chuan);
		System.out.println("so lan "+sl);
	}
	
	
}
