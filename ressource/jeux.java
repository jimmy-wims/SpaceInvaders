import java.util.Scanner;
public class jeux
{
	public static void vaisseau(int h,int l,InterfaceSpaceInvaders inter,java.awt.Color w,java.awt.Color red)
	{
		int i,j;
		for(i=l;i<=l+8;i++)
		{
			for(j=h;j<=h+6;j++)
			{
				if((((i==l)||(i==l+8))&&((j>h+3)&&(j<h+7)))||(((i==l+1)||(i==l+7))&&(j==h+5))||(((i==l+2)||(i==l+6))&&((j>=h+3)&&(j<=h+5)))||(((i==l+3)||(i==l+5))&&((j==h+2)||(j==h+6)))||((i==l+4)&&(j!=h+2)))
				{
					inter.modifieCase(i,j,w);//dessine la partie blanche du vaisseau
				}
				if ((((i==l+3)||(i==l+5))&&((j==h+3)||(j==h+4)||(j==h+5)))||((i==l+4)&&(j==h+2)))
				{
					inter.modifieCase(i,j,red);//dessine la partie rouge du vaisseau
				}
			}
		}   
	}
	public static int analyseVertDebut(int [][]tabentier,int i)
	{
		int j,x;
		x=0;
		for(j=0;j<=4;j=j+1)
		{
			if(tabentier[i][j]==1)
			{
				x=x+1;
			}
		}
		if(x!=0)
		{
			return i;
		}
		return analyseVertDebut(tabentier,i+1);
	}
	public static int analyseVertFin(int [][]tabentier,int i)
	{
		int j,x;
		x=0;
		for(j=0;j<=4;j=j+1)
		{
			if(tabentier[i][j]==1)
			{
				x=x+1;
			}
		}
		if(x!=0)
		{
			return i;
		}
		return analyseVertDebut(tabentier,i-1);
	}
	public static int analysehoriz(int [][]tabentier)
	{
		int i,j,x,total;
		x=0;
		total=0;
		for(j=0;j<=4;j=j+1)
		{
			x=0;
			for(i=0;i<=9;i=i+1)
			{
				if(tabentier[i][j]==1)
				{
					x=x+1;
				}
			}
			if(x!=0)
			{
					total=total+1;
			}
		}
		return total-1;
	}
	public static int trouvej(int [][]tabentier,int nombre)
	{
		int i,j,x;
		i=nombre;
		x=0;
		for(j=0;j<=4;j=j+1)
		{
			if(tabentier[i][j]==1)
			{
				x=j;
			}
		}
		return x;
	}
	public static int trouvei(int [][]tabentier,int total)
	{
		int i,j,x;
		x=0;
		j=total;
		for(i=0;i<=9;i=i+1)
		{
			if(tabentier[i][j]==1)
			{
				x=i;
			}
		}
		return x;
	}
	public static void missile(int l,int h,InterfaceSpaceInvaders inter,java.awt.Color w)
	{
		int x,y;
		x=l+2;
		y=h+2;
		inter.modifieCase(x,y,w); //dessine le missile
		inter.modifieCase(x,y-1,w);
	}
	public static void monstre(alien a,InterfaceSpaceInvaders inter,int numero,java.awt.Color green)
	{
		int i,j;
		if(numero==4)
		{
			for(i=a.c;i<=a.c+10;i=i+1)
			{
				for(j=a.b;j<=a.b+7;j=j+1)
				{
					if((((i==a.c)||(i==a.c+10))&&((j>a.b)&&(j<a.b+4)))||(((i==a.c+1)||(i==a.c+9))&&((j==a.b+3)||(j==a.b+4)))||(((i==a.c+2)||(i==a.c+8))&&((j==a.b)||((j>a.b+1)&&(j<a.b+7))))||(((i==a.c+3)||(i==a.c+7))&&((j!=a.b)&&(j!=a.b+3)&&(j!=a.b+6)))||(((i==a.c+4)||(i==a.c+6))&&((j==a.b+7)||((j>a.b+1)&&(j<a.b+6))))||((i==a.c+5)&&((j!=a.b)&&(j!=a.b+1)&&(j!=a.b+6)&&(j!=a.b+7))))
					{
						inter.modifieCase(i,j,green);//dessine monstre bras levé
					}
				}
			}
		}
		else
		{
			for(i=a.c;i<=a.c+10;i=i+1)
			{
				for(j=a.b;j<=a.b+7;j=j+1)
				{
					if((((i==a.c)||(i==a.c+10))&&((j>a.b+3)&&(j<a.b+7)))||(((i==a.c+1)||(i==a.c+9))&&((j==a.b+3)||(j==a.b+4)))||(((i==a.c+2)||(i==a.c+8))&&((j==a.b)||((j>a.b+1)&&(j<a.b+7))))||(((i==a.c+3)||(i==a.c+7))&&((j!=a.b)&&(j!=a.b+3)&&(j!=a.b+6)))||(((i==a.c+4)||(i==a.c+6))&&((j==a.b+7)||((j>a.b+1)&&(j<a.b+6))))||((i==a.c+5)&&((j!=a.b)&&(j!=a.b+1)&&(j!=a.b+6)&&(j!=a.b+7))))
					{
						inter.modifieCase(i,j,green);//dessine monstre bras baissé
					}
				}
			}
		}
	}
	public static void vie(int x,int y,InterfaceSpaceInvaders inter,java.awt.Color w)
	{
		int i,j;
		for(i=x;i<=x+16;i=i+1)
		{
			for(j=y;j<=y+6;j=j+1)
			{
				if((((i==x)||(i==x+4))&&((j>=y)&&(j<y+5)))||(((i==x+1)||(i==x+3))&&(j==y+5))||((i==x+2)&&(j==y+6)))
				{
					inter.modifieCase(i,j,w);//dessine un V
				}
				if((((i>=x+6)&&(i<=x+10))&&((j==y)||(j==y+6)))||((i==x+8)&&(j>=y)))
				{
					inter.modifieCase(i,j,w);//dessine un I
				}
				if((((j==y)||(j==y+3)||(j==y+6))&&(i>x+12))||((i==x+12)&&(j>=y)))
				{
					inter.modifieCase(i,j,w);//dessine un E
				}
			}
		}
	}
	public static void coeur(int x,int y,int element,InterfaceSpaceInvaders inter,java.awt.Color red)
	{
		int n,posx,i,j;
		for(n=0;n<=element-1;n=n+1)//nombre de coeur
		{
			for(i=x;i<=x+8;i=i+1)
			{
				for(j=y;j<=y+7;j=j+1)
				{
					if(((i==x)||(i==x+8))&&((j>y)&&(j<y+4)))
					{
						inter.modifieCase(i,j,red);
					}
					if(((i==x+1)||(i==x+7))&&((j>=y)&&(j<y+5)))
					{
						inter.modifieCase(i,j,red);
					}
					if(((i==x+2)||(i==x+6))&&((j>=y)&&(j<y+6)))
					{
						inter.modifieCase(i,j,red);
					}
					if(((i==x+3)||(i==x+5))&&((j>y)&&(j<y+7)))
					{
						inter.modifieCase(i,j,red);
					}
					if((i==x+4)&&(j>y+1))
					{
						inter.modifieCase(i,j,red);
					}
				}
			}
			x=i+3;
		}
	}
	public static void mouvement(alien [][] tab,int n,int depy,int taille,InterfaceSpaceInvaders inter,int numero,int coordonnee,int total,int arret,int fin,int debut,int coordonneejdebut,int coordonneejfin,java.awt.Color couleur,java.awt.Color black)
	{
		int depx,i,j,efface;
		efface=4;
		if(numero!=0)
		{
			efface=0;
		}
		if(n%2==0)
		{
			depx=1;//mouvement a droite
		}
		else
		{
			depx=-1;//mouvement a gauche
		}
		if((tab[fin][coordonneejfin].c!=taille)&&(tab[debut][coordonneejdebut].c!=0))
		{
			for(i=0;i<=9;i=i+1)
			{
				for(j=0;j<=4;j=j+1)
				{
					if(tab[i][j].vie==true)
					{
						monstre(tab[i][j],inter,efface,black);
						tab[i][j].c=tab[i][j].c+depx;//mouvement vers la gauche ou la droite
						monstre(tab[i][j],inter,numero,tab[i][j].couleur);
					}
				}
			}
		}
		else
		{
			if(tab[coordonnee][total].b>=arret)
			{
				for(i=0;i<=9;i=i+1)
				{
					for(j=0;j<=4;j=j+1)
					{
						monstre(tab[i][j],inter,efface,black);
						if(tab[i][j].vie==true)
						{
							tab[i][j].c=tab[i][j].c+depx;//mouvement vers la gauche ou la droite
							monstre(tab[i][j],inter,numero,tab[i][j].couleur);
						}
					}
				}
			}
			else
			{
				for(i=0;i<=9;i=i+1)
				{
					for(j=0;j<=4;j=j+1)
					{
						monstre(tab[i][j],inter,efface,black);
						if(tab[i][j].vie==true)
						{
							tab[i][j].b=tab[i][j].b+2;//descente des monstres
							tab[i][j].c=tab[i][j].c+depx;
							monstre(tab[i][j],inter,numero,tab[i][j].couleur);
						}	
					}
				}
			}
		}
	}
	static class alien
	{
		int c;
		int b;
		java.awt.Color couleur;
		boolean vie;
	}
	static class tir
	{
		int x;
		int y;
	}
 public static void main(String[] args) 
	  {   
	  	alien [][] tab= new alien[10][5];
	  	alien [] pos= new alien[50];
		int [][] repereentier = new int [10][5];
	  	tir tirmonstre1=new tir();
	  	tir tirmonstre2=new tir();
	  	int point,s,cpt,i,j,nbalien,taille,depy,k,m,nbalea,nbaleaDeux,numero,efface,total,arret,coordonneei,debut,fin,coordonneejDebut,coordonneejFin;
		int largeur,hauteur,touche,nbvie,n,h,l,x,y;
		Boolean rejouer,cptireUn,cptireDeux,gagne,mort,toucher,perdrevie,tirm1,tirm2;;
		efface=4;
		arret=145;
	  	cptireDeux=false;
	  	cptireUn=false;
	  	point=0;
	  	depy=0;
	  	taille=190;
	  	nbalien=0;
	  	cpt=0;
		numero=0;
		n=0;	
		nbvie=3;
		x=0;
	  	y=0;
		largeur=200;
		hauteur=200;
		tirm2=true;
		tirm1=true;
		perdrevie=false;
		toucher=false;
		gagne=false;
		mort=false;
		h=hauteur-hauteur/10;
		l=largeur-largeur/2;
		java.awt.Color black = new java.awt.Color(0,0,0);
		java.awt.Color green = new java.awt.Color(0,255,0);
		java.awt.Color w = new java.awt.Color(255,255,255);
		java.awt.Color red = new java.awt.Color(255,0,0);
		InterfaceSpaceInvaders inter = new InterfaceSpaceInvaders(largeur,hauteur,black);
		vaisseau(h,l,inter,w,red);
		vie(140,7,inter,w);
		coeur(165,7,nbvie,inter,red);
		for(i=25;i<=160;i=i+15)
		{
			for(j=42;j<=90;j=j+12)
			{
				pos[nbalien]=new alien();
				pos[nbalien].c=i;
				pos[nbalien].b=j;
				nbalien=nbalien+1;
			}
		}
		nbalien=0;
		for(i=0;i<=9;i=i+1)
		{
			for(j=0;j<=4;j=j+1)
			{
				tab[i][j]=new alien();
				tab[i][j].c=pos[nbalien].c;
				tab[i][j].b=pos[nbalien].b;
				tab[i][j].couleur=green;
				tab[i][j].vie=true;
				nbalien=nbalien+1;
			}
		}
		nbalien=0;
		for(i=0;i<=9;i=i+1)
		{
			for(j=0;j<=4;j=j+1)
			{
				repereentier[i][j]=1;
			}
		}
		while (gagne==false && mort==false)
		{
			if(numero!=0)
				{
					efface=0;
				}
			touche= inter.toucheTapee();
			if (touche==0)
			{   
				if(cpt==0)
				{
					cpt=cpt+1;
					x=l+2;
					y=h-6;
				}
			}
			if (touche!=0)
			{
				if (touche==1)
				{
					if(l>=5)
					{
						vaisseau(h,l,inter,black,black);
						l=l-5;
						vaisseau(h,l,inter,w,red);//mouvement du vaisseau a gauche 
					}
				}				
				if (touche==2)
				{
					if(l<190)
					{
						vaisseau(h,l,inter,black,black);
						l=l+5;
						vaisseau(h,l,inter,w,red);//mouvement du vaisseaua droite
					}
				}
				if (touche==3)
				{
					inter.afficheMessage(" Menu pause" );
				}
			}    
			for(i=0;i<=9;i=i+1)
			{
				for(j=0;j<=4;j=j+1)
				{
					if((x>=(tab[i][j].c-1)&&(x<=tab[i][j].c+10))&&((y>=tab[i][j].b-1)&&(y<=tab[i][j].b+7))&&(tab[i][j].vie==true))//un tir touche un monstre
					{
						tab[i][j].couleur=black;
						monstre(tab[i][j],inter,efface,black);
						tab[i][j].vie=false;
						missile(x,y,inter,black);
						y=-1;
						point=point+10;
						repereentier[i][j]=0;
					}
				}
			}
			debut=analyseVertDebut(repereentier,0);
			fin=analyseVertFin(repereentier,9);
			coordonneejDebut=trouvej(repereentier,debut);
			coordonneejFin=trouvej(repereentier,fin);
			total=analysehoriz(repereentier);
			coordonneei=trouvei(repereentier,total);
			if((cpt==1)&&(toucher==false))
			{
				missile(x,y,inter,black);
				y=y-5;
				missile(x,y,inter,w);
				if((y<16)||(toucher==true))
				{
					cpt=cpt-1;
					missile(x,y,inter,black);
				}
			}
			if((tab[fin][coordonneejFin].c==taille)||(tab[debut][coordonneejDebut].c==0))
			{
				n=n+1;
				depy=0;
			}
			if(tirm1==true)
			{
				i=(int)(Math.random()*(5));
				tirmonstre1.x=tab[i][total].c+5;
				tirmonstre1.y=tab[i][total].b+10;
				cptireUn=true;
				tirm1=false;
			}
			if(cptireUn==true)
			{
				missile(tirmonstre1.x,tirmonstre1.y,inter,black);
				tirmonstre1.y=tirmonstre1.y+3;
				missile(tirmonstre1.x,tirmonstre1.y,inter,w);
				if(tirmonstre1.y>201)
				{
					cptireUn=false;
					missile(tirmonstre1.x,tirmonstre1.y,inter,black);
					tirm1=true;
				}
			}
			if(tirm2==true)
			{
				s=(int)(Math.random()*(4)+6);
				tirmonstre2.x=tab[s][total].c+5;
				tirmonstre2.y=tab[s][total].b+10;
				cptireDeux=true;
				tirm2=false;
			}
			if(cptireDeux==true)
			{
				missile(tirmonstre2.x,tirmonstre2.y,inter,black);
				tirmonstre2.y=tirmonstre2.y+3;
				missile(tirmonstre2.x,tirmonstre2.y,inter,w);
				if(tirmonstre2.y>201)
				{
					cptireDeux=false;
					missile(tirmonstre2.x,tirmonstre2.y,inter,black);
					tirm2=true;
				}
			}
			if(((tirmonstre1.x>=l)&&(tirmonstre1.x<=l+8))&&((tirmonstre1.y>=h+1)&&(tirmonstre1.y<=h+6)))
			{
				perdrevie=true;
				missile(tirmonstre1.x,tirmonstre1.y,inter,black);
				tirmonstre1.y=202;
			}
			if(((tirmonstre2.x>=l)&&(tirmonstre2.x<=l+8))&&((tirmonstre2.y>=h+1)&&(tirmonstre2.y<=h+6)))
			{
				perdrevie=true;
				missile(tirmonstre2.x,tirmonstre2.y,inter,black);
				tirmonstre1.y=202;
			}
			if(perdrevie==true)
			{
				nbvie=nbvie-1;
				for(i=0;i<=9;i=i+1)
				{
					for(j=0;j<=4;j=j+1)
					{
						monstre(tab[i][j],inter,efface,black);
					 }
				}
				if(nbvie==2)
				{
					coeur(165,7,3,inter,black);
					coeur(165,7,2,inter,red);
				}
				if(nbvie==1)
				{
					coeur(165,7,2,inter,black);
					coeur(165,7,1,inter,red);
				}
				if(nbvie==0)
				{
					coeur(165,7,1,inter,black);
				}
				nbalien=0;
				for(i=0;i<=9;i=i+1)
				{
					for(j=0;j<=4;j=j+1)
					{
						if( tab[i][j].vie==true)
						{
							tab[i][j].c=pos[nbalien].c;
							tab[i][j].b=pos[nbalien].b;
							tab[i][j].couleur=green;
							tab[i][j].vie=true;
						}
						nbalien=nbalien+1;
					}
				}
				nbalien=0;
				n=0;
				perdrevie=false;
				vaisseau(h,l,inter,w,red);
			}	
			try{Thread.sleep(100);
					mouvement(tab,n,depy,taille,inter,numero,coordonneei,total,arret,fin,debut,coordonneejDebut,coordonneejFin,green,black);
				} catch(InterruptedException e){} 
			if (point==500) 
			{
				gagne=true;
			}
			if(nbvie==0)
			{
				mort=true;
			}
			if(mort==true||gagne==true)
			{
				if(gagne==true)
				{
					inter.afficheMessage("Bravo Vous avez gagne !!! tu as " + point + " points. Tu peux rejouer");
				}
				if(mort==true)
				{
					inter.afficheMessage("Dommage vous avez perdu !!! tu as " + point + " points. Tu peux retenter ta chance" );
				}
				inter.afficheMessage("Voulez vous rejouer ? Cliquez sur ok et entrez dans l'invite de commande (true ou false)");
				System.out.println("Voulez vous rejouer ?");
				rejouer =(new Scanner(System.in)).nextBoolean(); 
				if(rejouer==true)//relance une partie
				{
					nbvie=3;
					point=0;
					mort=false;
					gagne=false;
					coeur(165,7,nbvie,inter,red);
					missile(tirmonstre1.x,tirmonstre1.y,inter,black);
					missile(tirmonstre2.x,tirmonstre2.y,inter,black);
					missile(x,y,inter,black);
					for(i=0;i<=9;i=i+1)
					{
						for(j=0;j<=4;j=j+1)
						{
							tab[i][j].c=pos[nbalien].c;
							tab[i][j].b=pos[nbalien].b;
							tab[i][j].couleur=green;
							tab[i][j].vie=true;
							nbalien=nbalien+1;
						}
					}					
				}
			}	
			if(numero==4)
			{
				numero=0;
			}
			else
			{
				numero=numero+1;
			}
		}
	}
}