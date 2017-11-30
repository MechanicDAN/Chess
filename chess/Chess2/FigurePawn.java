package Chess2;

import java.lang.reflect.Field;

public class FigurePawn extends ChessFigure {
	byte count = 0;

	public FigurePawn(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2659');
		else
			this.setLabel('\u265F');
	}

	@Override
	boolean CanMove(byte to_x, byte to_y) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		if (this.getColor()) {
			// white
			if(x-to_x==0) {
				if (count == 0 && to_y - y == 2)
					if (!Worker.Field[x][to_y].getIsActive() && !Worker.Field[x][to_y - 1].getIsActive()) {
						count++;
						return true;
					}
				if(to_y-y==1)
					if(!Worker.Field[x][to_y].getIsActive()){
					count++;
					return true;
					}
			}
			if(x-to_x==1||to_x-x==1)
				if(to_y-y==1)
					if(Worker.Field[to_x][to_y].getIsActive()){
				count++;
				return true;
			}

		}
		else {
			// black
			if(x-to_x==0) {
				if (count == 0 && y - to_y == 2)
					if (!Worker.Field[x][to_y].getIsActive() && !Worker.Field[x][to_y + 1].getIsActive()) {
						count++;
						return true;
					}
				if(y-to_y==1)
					if(!Worker.Field[x][to_y].getIsActive()){
						count++;
						return true;
					}
			}
			if(x-to_x==1||to_x-x==1)
				if(y-to_y==1)
					if(Worker.Field[to_x][to_y].getIsActive()){
						count++;
						return true;
					}
		}
		return false;
	}

	@Override
	void Move(byte to_x, byte to_y) {
		if(this.getColor()) {
			if (to_y != 7) {
				this.setCoordinate_x(to_x);
				this.setCoordinate_y(to_y);
			}
			if(to_y==7){
				this.setCoordinate_x(to_x);
				this.setCoordinate_y(to_y);
				Worker.Field[to_x][to_y]=new FigureQueen((byte)to_x,(byte)to_y,true);
			}
		}
		else{
			if(to_y!=0){
				this.setCoordinate_x(to_x);
				this.setCoordinate_y(to_y);}
			if(to_y==0){
				this.setCoordinate_x(to_x);
				this.setCoordinate_y(to_y);
				Worker.Field[to_x][to_y]=new FigureQueen((byte)to_x,(byte)to_y,false);
			}
		}

	}
}
