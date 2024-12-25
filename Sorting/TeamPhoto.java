import java.util.ArrayList;
import java.util.List;

public class TeamPhoto {

    /**
     * Design an algorithm that takes as input two teams and the heights of the players in
     * the teams and checks if it is possible to place players to take the photo subject to the
     * placement constraint
     */

    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */

     static class Player implements Comparable<Player>{
        public Integer height;

        @Override
        public int compareTo(Player o) {
            return Integer.compare(height, o.height);
        }
    }


    static class Team{
         private List<Player> players;

        public Team(List<Integer> heights) {
            this.players = new ArrayList<>();
            for (Integer height : heights) {
                Player player = new Player();
                player.height = height;
                players.add(player);
            }
        }

        public static boolean validPlacementExists(Team team1, Team team2){
            team1.sortPlayersByHeight();
            team2.sortPlayersByHeight();

            for (int i = 0; i < team1.players.size(); i++) {
                if (team1.players.get(i).height >= team2.players.get(i).height) {
                    return false;
                }
            }
            return true;
        }

        private void sortPlayersByHeight(){
            players.sort(Player::compareTo);
        }
    }

}
