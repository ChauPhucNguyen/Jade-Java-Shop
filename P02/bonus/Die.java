

public class Die
{
 private int faces;
 
public Die (int faces)
{
 this.faces = faces;
}

public int getFaces()
{
 return faces;
}

public int roll()
{
 return (int)(Math.random()*faces) + 1;
}
}
