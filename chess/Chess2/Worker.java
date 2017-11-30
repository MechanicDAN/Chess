package Chess2;
import java.util.Scanner;

public class Worker {
	static ChessFigure[][] Field;
	static Scanner sc;
	static byte[] Coor;
	static boolean logs = true;
	static String history1="";
	static String history2="";

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Coor = new byte[4];
		MakeField();
		ShowField();
		while (true) {
			if (readInputData())
					if (Field[Coor[0]][Coor[1]].CanMove(Coor[2], Coor[3])) {
						if (logs) {
							System.out.println(Field[Coor[0]][Coor[1]].getClass());
							System.out.println("Yes");
						}
						if (Field[Coor[2]][Coor[3]].getLabel() == '\u2654' || Field[Coor[2]][Coor[3]].getLabel() == '\u265A') {
							System.out.println("You Win");
							return;
						}
						if (Field[Coor[2]][Coor[3]].getColor() && Field[Coor[2]][Coor[3]].getIsActive())
							history1 += Field[Coor[2]][Coor[3]].toString();
						if (!Field[Coor[2]][Coor[3]].getColor() && Field[Coor[2]][Coor[3]].getIsActive())
							history2 += Field[Coor[2]][Coor[3]].toString();
						if (Field[Coor[2]][Coor[3]].getIsActive()) Field[Coor[2]][Coor[3]].setIsActive(false);
						Field[Coor[2]][Coor[3]] = Field[Coor[0]][Coor[1]];
						Field[Coor[2]][Coor[3]].Move(Coor[2], Coor[3]);
						Field[Coor[0]][Coor[1]] = new EmptyFigure(Coor[0], Coor[1]);

					} else {
						if (logs) {
							System.out.println(Field[Coor[0]][Coor[1]].getClass());
							System.out.println("No");
						}
					}
			ShowField();
		}
	}

	static void MakeField() {
		Field = new ChessFigure[8][8];
		for (byte i = 0; i < 8; i++)
			for (byte j = 0; j < 8; j++)
				Field[i][j] = new EmptyFigure(i, j);
		for (byte i = 0; i < 8; i++) {
			Field[i][6] = new FigurePawn(i, (byte) 6, false);
			Field[i][1] = new FigurePawn(i, (byte) 1, true);
		}
		Field[0][0]=new FigureRook((byte)0,(byte)0,true);
		Field[7][0]=new FigureRook((byte)7,(byte)0,true);
		Field[0][7]=new FigureRook((byte)0,(byte)7,false);
		Field[7][7]=new FigureRook((byte)7,(byte)7,false);

		Field[1][0]=new FigureKnight((byte)1,(byte)0,true);
		Field[6][0]=new FigureKnight((byte)6,(byte)0,true);
		Field[1][7]=new FigureKnight((byte)1,(byte)7,false);
		Field[6][7]=new FigureKnight((byte)6,(byte)7,false);

		Field[2][0]=new FigureBishop((byte)2,(byte)0,true);
		Field[5][0]=new FigureBishop((byte)5,(byte)0,true);
		Field[2][7]=new FigureBishop((byte)2,(byte)7,false);
		Field[5][7]=new FigureBishop((byte)5,(byte)7,false);

		Field[3][0]=new FigureQueen((byte)3,(byte)0,true);
		Field[3][7]=new FigureQueen((byte)3,(byte)7,false);

		Field[4][0]=new FigureKing((byte)4,(byte)0,true);
		Field[4][7]=new FigureKing((byte)4,(byte)7,false);

	}

	static void ShowField() {
		for (byte i = 7; i > -1; i--) {
			System.out.print((i + 1) + "-");
			for (byte j = 0; j < 8; j++)
				System.out.print(Field[j][i].toString());
			System.out.println();
		}
		System.out.println("  A B C DE F G H");
		System.out.println("Player1=="+history1);
		System.out.println("Player2=="+history2);
	}

	static boolean readInputData() {
		boolean flag = true;
		String input = sc.nextLine().toLowerCase();
		if (input != null) {
			Coor[0] = (byte) (input.charAt(0) - 'a');// from X
			Coor[1] = (byte) (input.charAt(1) - '1');// from Y
			Coor[2] = (byte) (input.charAt(3) - 'a');// to X
			Coor[3] = (byte) (input.charAt(4) - '1');// to Y
			for (byte i = 0; i < Coor.length; i++)
				if (Coor[i] < 0 || Coor[i] > 7)
				{flag = false;System.out.println("False");}
			if((Coor[0]==Coor[2])&&(Coor[1]==Coor[3])) {flag = false;System.out.println("False");}
			if (logs) {
				System.out.println(input);
				for (byte i = 0; i < Coor.length; i++)
					System.out.print(Coor[i] + "; ");
			}
			return flag;
		}
		return false;
		
		
		
		
		
		
		
	}

}
