public class Fuse
{
  private int time;
  
  public Fuse(int time)
  {
   this.time = time;
  }
  
  public boolean burn()
  {
   if(time > 0)
   {
    time--;
    return true;
   }
   else
   {
    return false;
   }
   }

  @Override
  public String toString()
  {
   return "BOOM, YOU LOSE!";
  }
}
