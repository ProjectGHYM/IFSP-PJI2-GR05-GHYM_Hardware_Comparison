package View.Icones;

import java.net.URL;

import ModelEntidade.Software;

public class ForneceURL 
{
        public URL getURL(Software s)
        {
            return getClass().getResource(s.getlocalizacao());
        }

        public URL getURL(String s)
        {
            return getClass().getResource(s);
        }
}
