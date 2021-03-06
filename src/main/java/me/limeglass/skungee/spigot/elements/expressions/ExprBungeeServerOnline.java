package me.limeglass.skungee.spigot.elements.expressions;

import java.util.Set;

import org.bukkit.event.Event;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Name;
import me.limeglass.skungee.objects.SkungeePacket;
import me.limeglass.skungee.objects.SkungeePacketType;
import me.limeglass.skungee.spigot.lang.SkungeePropertyExpression;
import me.limeglass.skungee.spigot.sockets.Sockets;
import me.limeglass.skungee.spigot.utils.annotations.Properties;
import me.limeglass.skungee.spigot.utils.annotations.PropertiesAddition;

@Name("Bungeecord server online state")
@Description("Returns the message of the day(s) from the defined server(s).")
@Properties({"strings", "online stat(us|e)[s]", "{1}[(all [[of] the]|the)]"})
@PropertiesAddition("[bungee[[ ]cord]] [server[s]]")
public class ExprBungeeServerOnline extends SkungeePropertyExpression<String, Boolean> {
	
	@Override
	protected Boolean[] get(Event event, String[] servers) {
		if (isNull(event)) return null;
		@SuppressWarnings("unchecked")
		Set<Boolean> onlines = (Set<Boolean>) Sockets.send(new SkungeePacket(true, SkungeePacketType.ISSERVERONLINE, servers));
		return (onlines != null) ? onlines.toArray(new Boolean[onlines.size()]) : null;
	}
}