public class Rectangle<T>
{
   private T length;
   private T width;

   public Rectangle(T len, T wid)
   {
      length = len;
      width = wid;
   }
   
   public T getLength()
   {
      return length;
   }
   
   public void setLength(T len)
   {
      length = len;
   }
   
   public T getWidth()
   {
      return width;
   }
   
   public void setWidth(T wid)
   {
      width = wid;
   }
 
}
