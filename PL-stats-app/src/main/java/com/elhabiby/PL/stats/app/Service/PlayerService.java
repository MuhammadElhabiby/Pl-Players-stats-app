package com.elhabiby.PL.stats.app.Service;

import com.elhabiby.PL.stats.app.Entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    List<Player> getPlayersFromTeam(String teamName);

    List<Player> getPlayersByName(String searchText);

    List<Player> getPlayersByPos(String searchText);

    List<Player> getPlayersByNation(String searchText);

    List<Player> getPlayersByTeamAndPosition(String team, String position);

    Player addPlayer(Player player);

    Player updatePlayer(Player updatedPlayer);

    void deletePlayer(String playerName);

}
