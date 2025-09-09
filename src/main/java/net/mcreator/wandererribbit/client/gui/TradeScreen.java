package net.mcreator.wandererribbit.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.wandererribbit.world.inventory.TradeMenu;
import net.mcreator.wandererribbit.procedures.ModCheckProcedure;
import net.mcreator.wandererribbit.network.TradeButtonMessage;
import net.mcreator.wandererribbit.init.WandererRibbitModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TradeScreen extends AbstractContainerScreen<TradeMenu> implements WandererRibbitModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_trade;

	public TradeScreen(TradeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("wanderer_ribbit:textures/screens/trade.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + -131 && mouseX < leftPos + -107 && mouseY > topPos + -59 && mouseY < topPos + -35) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_amethyst"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -107 && mouseX < leftPos + -83 && mouseY > topPos + -59 && mouseY < topPos + -35) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_compass"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -66 && mouseX < leftPos + -42 && mouseY > topPos + -59 && mouseY < topPos + -35) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_ribbit_map"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (ModCheckProcedure.execute())
			if (mouseX > leftPos + -130 && mouseX < leftPos + -106 && mouseY > topPos + -28 && mouseY < topPos + -4) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_emerald"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ModCheckProcedure.execute())
			if (mouseX > leftPos + -106 && mouseX < leftPos + -82 && mouseY > topPos + -28 && mouseY < topPos + -4) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_amethyst1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ModCheckProcedure.execute())
			if (mouseX > leftPos + -65 && mouseX < leftPos + -41 && mouseY > topPos + -27 && mouseY < topPos + -3) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.wanderer_ribbit.trade.tooltip_frog_pill"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("wanderer_ribbit:textures/screens/gui0.png"), this.leftPos + -130, this.topPos + -82, 0, 0, 260, 165, 260, 165);
		if (ModCheckProcedure.execute()) {
			guiGraphics.blit(ResourceLocation.parse("wanderer_ribbit:textures/screens/bbtrade.png"), this.leftPos + -127, this.topPos + -27, 0, 0, 84, 20, 84, 20);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_trade = Button.builder(Component.translatable("gui.wanderer_ribbit.trade.button_trade"), e -> {
			int x = TradeScreen.this.x;
			int y = TradeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TradeButtonMessage(0, x, y, z));
				TradeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 18, this.topPos + -27, 51, 20).build();
		this.addRenderableWidget(button_trade);
	}
}