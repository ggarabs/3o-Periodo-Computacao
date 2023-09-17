import java.util.Scanner;

public class StreamObject{ //Classe fila
	private int streamID, streamData;
	public static final int ID_DEFAULT = 0, DATA_DEFAULT = 0;
	Scanner input = new Scanner(System.in);

	public StreamObject(int ID, int data){ //Construtores da fila
		setID(ID);
		setData(data);
	}

	public StreamObject(){ this(ID_DEFAULT, DATA_DEFAULT); }

	public int getData(){ return this.streamData; }

	public void setData(int newData){ this.streamData = newData; }

	public int getID(){ return this.streamID; }

	public void setID(int newID){ this.streamID = newID; }

}
