package Lab04.AimProject.src.aims.media;


    public class Disc extends Media {
        public int length;
        public String director;
        
         public Disc(int id, String title, String category, float cost, int length, String director) {
                super( title, category, cost);  // Gọi constructor của lớp Media
                this.length = length;
                this.director = director;
            }
        public int getLength() {
            return length;
        }
        public String getDirector() {
            return director;
        }
    
    }

