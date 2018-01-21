//  Mohammad Maruf Imtiaze
//  Tic tac toe game

#include<stdio.h>
#include<stdlib.h>
#include<windows.h>

void playerX();
void playerY();
void play();
void check();
void draw();
int check_draw();
void goodbye();
void gotoxy(int x, int y);

char ary[9]={'\0'};
char a[10],b[10];
int turn=1,in,win_check,win_count1,win_count2;


void gotoxy(int x, int y)
{
    COORD c = { x, y };
    SetConsoleCursorPosition ( GetStdHandle(STD_OUTPUT_HANDLE) , c);
}

/*################################################################*
                     Player 1's activity
*################################################################*/
void playerX(){

	fflush(stdin);
    scanf("%d",&in);													// Input a number for a block
	switch(in){
	case 1:
	case 2:
	case 3:
	case 4:
	case 5:
	case 6:
	case 7:
	case 8:
	case 9:
		if(ary[in-1]=='\0'){
			ary[in-1] = 'X';
			break;
		}
		else{
			gotoxy(12,19);	printf("\a\awrong choice !       ");
			gotoxy(12,20);	printf("Press again\t\t\t\t\t\n\t\t\t\t\t\t\t\t");
			gotoxy(26,20);
			playerX();
			break;
		}
	default:
		gotoxy(12,19);	printf("\a\awrong choice !       ");
		gotoxy(12,20);	printf("Press again\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t");
		gotoxy(26,20);
		playerX();
		break;
	}
        												 // Give the sign in inputted block
}

/*################################################################*
                      Player 2's activity
*################################################################*/

void playerY(){

	fflush(stdin);
    scanf("%d",&in);                                                    // Input a number for a block
	switch(in){
	case 1:
	case 2:
	case 3:
	case 4:
	case 5:
	case 6:
	case 7:
	case 8:	
	case 9:
		if(ary[in-1]=='\0'){
			ary[in-1] = 'O';
			break;
		}
		else{
			gotoxy(12,19);	printf("\a\awrong choice !       ");
			gotoxy(12,20);	printf("Press again\t\t\t\t\t\n\t\t\t\t\t\t\t\t");
			gotoxy(26,20);
			playerY();
			break;
		}
	default:
		gotoxy(12,19);	printf("\a\awrong choice !       ");
		gotoxy(12,20);	printf("Press again\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t");
		gotoxy(26,20);
		playerY();
		break;                                             
	}
}

/*###########################################################################################*
                  main work is here..
				  this function determine who is playing and who will play next..
				  it also check if win anyone and if this game will be draw..
*############################################################################################*/

void play(){
	char again;
	int i;

	draw();																// Draw the table
    if(turn == 1) {
		printf("%s's turn  ",a);
        playerX();
        check();

		if(win_check==1){
			win_count1++;
			draw();
			Beep(1500,400);
			printf("\t%s win\n"
					"\tDo you want to play again? Y/N\t",a);
			fflush(stdin);
			scanf("%c",&again);
			while(1){
				if(again=='Y' || again=='y'){
					win_check=0;
					turn=2;
					for(i=0;i<9;i++)
						ary[i]='\0';
					draw();
					play();
				}
				else if(again=='N' || again=='n'){
					goodbye();
					break;
				}
				else{
					gotoxy(40,20);
					printf("\a\a");
					fflush(stdin);
					scanf("%c",&again);
				}

			}

		}

		if(check_draw()){
			gotoxy(10,19);
			draw();
			Beep(300,400);			printf("Match draw !\t\t\t"
									"\n\tDo you want to play again? Y/N\t");

			fflush(stdin);
			scanf("%c",&again);
			while(1){
				if(again=='Y' || again=='y'){
					win_check=0;
					turn=2;									// Change the turn
					for(i=0;i<9;i++)
						ary[i]='\0';
					draw();
					play();									// Play again
				}
				else if(again=='N' || again=='n'){
					goodbye();								// Tata bye bye
					break;
				}
				else{
					gotoxy(40,20);
					printf("\a\a");
					fflush(stdin);
					scanf("%c",&again);
				}

			}
		}
		else{
			turn = 2;
			draw();
			play();
		}
    }

    else {
		printf("%s's turn  ",b);
        playerY();
        check();

		if(win_check==2){
			win_count2++;
			draw();
			Beep(1500,400);
			printf("\t%s win\n"
					"\tDo you want to play again? Y/N\t",b);

			fflush(stdin);
			scanf("%c",&again);
			while(1){
				if(again=='Y' || again=='y'){
					win_check=0;
					turn=1;                                //change player turn
					for(i=0;i<9;i++)
						ary[i]='\0';
					draw();
					play();
				}
				else if(again=='N' || again=='n'){
					goodbye();                            // tata bye bye
				}
				else{
					gotoxy(40,20);
					printf("\a\a");
					fflush(stdin);
					scanf("%c",&again);
				}
			}
		}

		if(check_draw()){

			gotoxy(10,19);
			draw();
			Beep(300,400);	printf("Match draw !\t\t\t"
									"\n\tDo you want to play again? Y/N\t");

			fflush(stdin);
			scanf("%c",&again);
			while(1){
				if(again=='Y' || again=='y'){
					win_check=0;
					turn=1;
					for(i=0;i<9;i++)
						ary[i]='\0';
					draw();
					play();
				}
				else if(again=='N' || again=='n'){
					goodbye();
					break;
				}
				else{
					gotoxy(40,20);
					printf("\a\a");
					fflush(stdin);
					scanf("%c",&again);
				}

			}
		}
		else{
			turn = 1;
			draw();
			play();
		}
    }
}

/*################################################################*
                  check who will win this time
*################################################################*/

void check(){

    if(ary[0]=='O' && ary[1]=='O' && ary[2]=='O')	win_check=2;
    if(ary[0]=='O' && ary[3]=='O' && ary[6]=='O')	win_check=2;
    if(ary[0]=='O' && ary[4]=='O' && ary[8]=='O')	win_check=2;
    if(ary[2]=='O' && ary[5]=='O' && ary[8]=='O')	win_check=2;
    if(ary[2]=='O' && ary[4]=='O' && ary[6]=='O')	win_check=2;
    if(ary[6]=='O' && ary[7]=='O' && ary[8]=='O')	win_check=2;
    if(ary[3]=='O' && ary[4]=='O' && ary[5]=='O')	win_check=2;
    if(ary[1]=='O' && ary[4]=='O' && ary[7]=='O')	win_check=2;

    if(ary[0]=='X' && ary[1]=='X' && ary[2]=='X')	win_check=1;
    if(ary[0]=='X' && ary[3]=='X' && ary[6]=='X')	win_check=1;
    if(ary[0]=='X' && ary[4]=='X' && ary[8]=='X')	win_check=1;
    if(ary[2]=='X' && ary[5]=='X' && ary[8]=='X')	win_check=1;
    if(ary[2]=='X' && ary[4]=='X' && ary[6]=='X')	win_check=1;
    if(ary[6]=='X' && ary[7]=='X' && ary[8]=='X')	win_check=1;
    if(ary[3]=='X' && ary[4]=='X' && ary[5]=='X')	win_check=1;
    if(ary[1]=='X' && ary[4]=='X' && ary[7]=='X')	win_check=1;

}

/*################################################################*
                    Say Tata bye bye to user
*################################################################*/

void goodbye(){
	int i,j;
	system("cls");

	gotoxy(35,3);	printf("Scorecard");
	gotoxy(29,5);	printf("%7s\t %7s",a,b);
	gotoxy(32,6);	printf("(X)\t    (O)");
	gotoxy(28,7);	printf("------------------------\n");

	for(i=1,j=5;i<=7;i++,j++){		gotoxy(39,j);	 printf("|");	}

	gotoxy(29,8);	printf("%5d",win_count1);
	gotoxy(41,8);	printf("%5d",win_count2);

	if(win_count1 > win_count2){
		gotoxy(13,14);	printf("Congratulation %s, You won.. %s, better luck next time !",a,b);
	}
	else if(win_count1 < win_count2){
		gotoxy(15,14);	printf("Congratulation %s, You won. %s, better luck next time !",b,a);
	}
	else{
		gotoxy(25,14);	printf("Both of you are intelligent !!");
	}
	gotoxy(23,16);	printf("Thank you for playing %s and %s.",a,b);
	gotoxy(32,18);	printf("Have a nice day !");
	gotoxy(17,23); printf("Copyright - Mohammad Maruf Imtiaze @ 2015");
	gotoxy(39,20);
	while(1);
}

/*################################################################*
                  for drawing the table
*################################################################*/

void draw() {

    int i,j;
	system("cls");

	for(i=0,j=9;i<=15;i++,j++){     if(i%5==0){  gotoxy(j,15);	 printf("+");   }
                                    else      {  gotoxy(j,15);	 printf("-");   }	}
    for(i=0,j=9;i<=15;i++,j++){     if(i%5==0){  gotoxy(j,3);	 printf("+");   }
                                    else      {  gotoxy(j,3);	 printf("-");   }	}
    for(i=0,j=9;i<=15;i++,j++){     if(i%5==0){  gotoxy(j,7);	 printf("+");   }
                                    else      {  gotoxy(j,7);	 printf("-");   }	}
    for(i=0,j=9;i<=15;i++,j++){     if(i%5==0){  gotoxy(j,11);	 printf("+");   }
                                    else      {  gotoxy(j,11);	 printf("-");   }	}

    for(i=0,j=3;i<=12;i++,j++){     if(i%4==0){  gotoxy(24,j);	 printf("+");   }
                                    else      {  gotoxy(24,j);	 printf("|");   }	}
    for(i=0,j=3;i<=12;i++,j++){     if(i%4==0){  gotoxy(14,j);	 printf("+");   }
                                    else      {  gotoxy(14,j);	 printf("|");   }	}
    for(i=0,j=3;i<=12;i++,j++){     if(i%4==0){  gotoxy(19,j);	 printf("+");   }
                                    else      {  gotoxy(19,j);	 printf("|");   }	}
    for(i=0,j=3;i<=12;i++,j++){     if(i%4==0){  gotoxy(9,j);	 printf("+");   }
                                    else      {  gotoxy(9,j);	 printf("|");   }	}


	for(i=0,j=12;i<3;i++,j+=5){		gotoxy(j,5);	printf("%c",ary[i]);	}
	for(i=3,j=12;i<6;i++,j+=5){		gotoxy(j,9);	printf("%c",ary[i]);	}
	for(i=6,j=12;i<9;i++,j+=5){		gotoxy(j,13);	printf("%c",ary[i]);	}


	gotoxy(46,5); printf("%7s\t  %7s",a,b);
	gotoxy(49,6); printf("(X)\t     (O)");
	gotoxy(46,7); printf("------------------------\n");
	for(i=1,j=5;i<=8;i++,j++){		gotoxy(56,j);	 printf("|");	}

	gotoxy(46,8); printf("%5d",win_count1);
	gotoxy(58,8); printf("%5d",win_count2);
	gotoxy(17,23); printf("Copyright - Mohammad Maruf Imtiaze @ 2015");
	gotoxy(12,19);
}

/*################################################################*
                  check if draw
*################################################################*/

int check_draw(){
	int i,draw_count=0;
	for(i=0;i<9;i++)
		if(ary[i]=='O' || ary[i]=='X')
			draw_count++;
	if(draw_count==9)
		return 1;
	else
		return 0;
}


int main(){

	printf("\n\n\n\n\tEnter player 1 name: ");	gets(a);
	printf("\n");
	printf("\n\n\n\tEnter player 2 name: ");	gets(b);

	play();
	while(1);
    return 0;
}