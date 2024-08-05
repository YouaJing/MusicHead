package tcc.youajing.musichead;
import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.sound.SoundStop;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;


public class Listener implements org.bukkit.event.Listener {
    private final MusicHead plugin;


    public Listener(MusicHead plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerArmorChange(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack oldItem;
        ItemStack newItem;
        PlayerArmorChangeEvent.SlotType slotType = event.getSlotType();

        if (slotType == PlayerArmorChangeEvent.SlotType.HEAD) {
            oldItem = event.getOldItem();
            newItem = event.getNewItem();

            if (oldItem != null) {
                if (oldItem.getType().isRecord()) {
                    Sound sound = getSoundFromItem(oldItem);
                    World world = player.getWorld();
                    if (sound != null) {
                        world.stopSound(SoundStop.named(sound));
                    }
                }
            }

            if (newItem != null) {
                if (newItem.getType().isRecord()) {
                    Sound sound = getSoundFromItem(newItem);
                    World world = player.getWorld();
                    String name = getNameFromItem(newItem);
                    if (sound != null) {
                        world.playSound(player, sound, 1.0f, 1.0f);
                    }

                    player.sendActionBar(ChatColor.AQUA +"- 你现在是一个" + ChatColor.YELLOW + name + ChatColor.RESET + ChatColor.AQUA + "唱片机 -");
                }
            }
        }
    }
    private Sound getSoundFromItem(ItemStack item) {
        Material material = item.getType();
        switch (material) {
            case MUSIC_DISC_11:
                return Sound.MUSIC_DISC_11;
            case MUSIC_DISC_13:
                return Sound.MUSIC_DISC_13;
            case MUSIC_DISC_5:
                return Sound.MUSIC_DISC_5;
            case MUSIC_DISC_BLOCKS:
                return Sound.MUSIC_DISC_BLOCKS;
            case MUSIC_DISC_CAT:
                return Sound.MUSIC_DISC_CAT;
            case MUSIC_DISC_CHIRP:
                return Sound.MUSIC_DISC_CHIRP;
            case MUSIC_DISC_FAR:
                return Sound.MUSIC_DISC_FAR;
            case MUSIC_DISC_MALL:
                return Sound.MUSIC_DISC_MALL;
            case MUSIC_DISC_MELLOHI:
                return Sound.MUSIC_DISC_MELLOHI;
            case MUSIC_DISC_OTHERSIDE:
                return Sound.MUSIC_DISC_OTHERSIDE;
            case MUSIC_DISC_PIGSTEP:
                return Sound.MUSIC_DISC_PIGSTEP;
            case MUSIC_DISC_RELIC:
                return Sound.MUSIC_DISC_RELIC;
            case MUSIC_DISC_STAL:
                return Sound.MUSIC_DISC_STAL;
            case MUSIC_DISC_STRAD:
                return Sound.MUSIC_DISC_STRAD;
            case MUSIC_DISC_WAIT:
                return Sound.MUSIC_DISC_WAIT;
            case MUSIC_DISC_WARD:
                return Sound.MUSIC_DISC_WARD;
            case MUSIC_DISC_PRECIPICE:
                return Sound.MUSIC_DISC_PRECIPICE;
            case MUSIC_DISC_CREATOR:
                return Sound.MUSIC_DISC_CREATOR;
            case MUSIC_DISC_CREATOR_MUSIC_BOX:
                return Sound.MUSIC_DISC_CREATOR_MUSIC_BOX;
            default:
                return null;
        }
    }


    private String getNameFromItem(ItemStack item) {
        Material material = item.getType();
        switch (material) {
            case MUSIC_DISC_11:
                return "11";
            case MUSIC_DISC_13:
                return "";
            case MUSIC_DISC_5:
                return "5";
            case MUSIC_DISC_BLOCKS:
                return "BLOCKS";
            case MUSIC_DISC_CAT:
                return "CAT";
            case MUSIC_DISC_CHIRP:
                return "CHIRP";
            case MUSIC_DISC_FAR:
                return "FAR";
            case MUSIC_DISC_MALL:
                return "MALL";
            case MUSIC_DISC_MELLOHI:
                return "MELLOHI";
            case MUSIC_DISC_OTHERSIDE:
                return "OTHERSIDE";
            case MUSIC_DISC_PIGSTEP:
                return "PIGSTEP";
            case MUSIC_DISC_RELIC:
                return "RELIC";
            case MUSIC_DISC_STAL:
                return "STAL";
            case MUSIC_DISC_STRAD:
                return "STRAD";
            case MUSIC_DISC_WAIT:
                return "WAIT";
            case MUSIC_DISC_WARD:
                return "WARD";
            default:
                return null;
        }
    }
}
