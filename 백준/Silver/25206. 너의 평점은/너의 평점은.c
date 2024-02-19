#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int main()
{	

	int i,j,n=20,l=0,flag = 0,y1=0,z1=0;
	double hak=0.0,hakhak =0.0,sum =0.0,hakhak2=0.0;
	char x[100],y[100],z[100];

	for(i=0;i<20;i++){
		gets(x);

		l = strlen(x);

		for(j=0;j<l;j++){
			if(flag == 0 && x[j] == ' '){
				x[j] = '\0';
				flag = 1;
				j++;
			}

			if(flag == 1 && x[j] == ' '){
				y[y1] = '\0';
				flag = 2;
				j++;
			}

			if(flag == 1){
				y[y1++] = x[j]; 
			}

			if(flag == 2){
				z[z1++] = x[j];
			}

		}

		z[z1] = '\0';

		hak = atof(y);

		if(z[0] == 'A'){
			if(z[1] == '+'){
				hakhak = 4.5;
			}
			else{
				hakhak = 4.0;
			}
		}
		
		else if(z[0] == 'B'){
			if(z[1] == '+'){
				hakhak = 3.5;
			}
			else{
				hakhak = 3.0;
			}
		}

		else if(z[0] == 'C'){
			if(z[1] == '+'){
				hakhak = 2.5;
			}
			else{
				hakhak = 2.0;
			}
		}

		else if(z[0] == 'D'){
			if(z[1] == '+'){
				hakhak = 1.5;
			}
			else{
				hakhak = 1.0;
			}
		}
		else if(z[0] == 'F'){
			hakhak = 0.0;
		}
		else{
			hakhak = 0.0;
			hak = 0.0;
		}

		hakhak2 = hakhak2+ hak;

		sum = sum + (hak * hakhak);

		y1 = 0;
		z1 = 0;
		flag = 0;

		


	}
	
	printf("%lf",sum /hakhak2);

	return 0;
}