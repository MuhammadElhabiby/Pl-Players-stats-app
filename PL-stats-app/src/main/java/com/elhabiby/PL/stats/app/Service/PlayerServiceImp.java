package com.elhabiby.PL.stats.app.Service;

import com.elhabiby.PL.stats.app.Entity.Player;
import com.elhabiby.PL.stats.app.Repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImp  implements PlayerService{
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerServiceImp(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepo.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByName(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByPos(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByNation(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepo.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }

    @Override
    public Player addPlayer(Player player) {
        playerRepo.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepo.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Override
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepo.deleteByName(playerName);
    }
}
