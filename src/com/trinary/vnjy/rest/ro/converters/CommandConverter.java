package com.trinary.vnjy.rest.ro.converters;

import javax.ws.rs.core.UriInfo;

import com.trinary.ro.v2.converter.ROConverter;
import com.trinary.vnjy.rest.ro.CommandRO;
import com.trinary.vnjy.se.Command;

public class CommandConverter extends ROConverter<CommandRO, Command> {

	public CommandConverter(UriInfo uriInfo) {
		super(uriInfo);
	}

	@Override
	protected Command _convertRO(CommandRO ro) {
		// UNUSED
		return null;
	}

	@Override
	protected CommandRO _convertEntity(Command entity) {
		CommandRO ro = new CommandRO();
		ro.setCommand(entity.getCommand());
		ro.setArgs(entity.getArgs());
		ro.setFrom(entity.getFrom());
		
		return ro;
	}

	@Override
	protected CommandRO _addLinks(CommandRO object) {
		// TODO Auto-generated method stub
		return null;
	}

}