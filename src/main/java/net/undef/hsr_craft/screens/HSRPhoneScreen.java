package net.undef.hsr_craft.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.undef.hsr_craft.HSRcraft;

public class HSRPhoneScreen extends AbstractContainerScreen<HSRPhoneMenu>{

    //Locations for all textures used in the screen
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(HSRcraft.MOD_ID, "textures/gui/hsr_phone_gui.png");
    private static final ResourceLocation PATH_BUTTON_LOCATION = new ResourceLocation(HSRcraft.MOD_ID, "textures/gui/path_button.png");
    private static final ResourceLocation CHARACTER_BUTTON_LOCATION = new ResourceLocation(HSRcraft.MOD_ID, "textures/gui/character_button.png");
    private static final ResourceLocation INVENTORY_BUTTON_LOCATION = new ResourceLocation(HSRcraft.MOD_ID, "textures/gui/inventory_button.png");
    private static final ResourceLocation PARTY_BUTTON_LOCATION = new ResourceLocation(HSRcraft.MOD_ID, "textures/gui/party_button.png");

    //Dimensions of the main image texture used for the screen
    private static final int IMAGE_WIDTH = 154;
    private static final int IMAGE_HEIGHT = 256;

    //Dimension of buttons
    private static final int BUTTON_WIDTH = 27; //Pixel length on screen

    //Declaration of any widgets being added and their positions on the screen
    private ImageButton pathButton;
    private static final int B1X = 40;
    private static final int B1Y = 93;

    private ImageButton characterButton;
    private static final int B2X = 86;
    private static final int B2Y = 93;

    private ImageButton inventoryButton;
    private static final int B3X = 40;
    private static final int B3Y = 163;

    private ImageButton partyButton;
    private static final int B4X = 86;
    private static final int B4Y = 163;

    public HSRPhoneScreen(HSRPhoneMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 99999;
        this.titleLabelY = 99999;

        int x = (width - IMAGE_WIDTH)/2;
        int y = (height - IMAGE_HEIGHT)/10;
        this.pathButton = this.addRenderableWidget(new ImageButton(x + B1X, y + B1Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, PATH_BUTTON_LOCATION, (pathButton) -> {}));
        //this.characterButton = this.addRenderableWidget(new ImageButton(x + B2X, y + B2Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, CHARACTER_BUTTON_LOCATION, (pathButton) -> {}));
        this.inventoryButton = this.addRenderableWidget(new ImageButton(x + B3X, y + B3Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, INVENTORY_BUTTON_LOCATION, (pathButton) -> {}));
        this.partyButton = this.addRenderableWidget(new ImageButton(x + B4X, y + B4Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, PARTY_BUTTON_LOCATION, (pathButton) -> {}));

        this.pathButton = this.addRenderableWidget(new ImageButton(x + B1X, y + B1Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, PATH_BUTTON_LOCATION, BUTTON_WIDTH, BUTTON_WIDTH, (pathButton) -> {}));
        this.characterButton = this.addRenderableWidget(new ImageButton(x + B2X, y + B2Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, CHARACTER_BUTTON_LOCATION, BUTTON_WIDTH, BUTTON_WIDTH, (pathButton) -> {}));
        this.inventoryButton = this.addRenderableWidget(new ImageButton(x + B3X, y + B3Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, INVENTORY_BUTTON_LOCATION, BUTTON_WIDTH, BUTTON_WIDTH, (pathButton) -> {}));
        this.partyButton = this.addRenderableWidget(new ImageButton(x + B4X, y + B4Y, BUTTON_WIDTH, BUTTON_WIDTH, 0, 0, 0, PARTY_BUTTON_LOCATION, BUTTON_WIDTH, BUTTON_WIDTH, (pathButton) -> {}));
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        //Position at which gui is rendered
        int x = (width - IMAGE_WIDTH)/2;
        int y = (height - IMAGE_HEIGHT)/10;
        pGuiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, 256, 256);
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if(this.pathButton.mouseClicked(pMouseX, pMouseY, pButton)){
            this.menu.pathButtonClicked();
            return true;
        }
        else if(this.characterButton.mouseClicked(pMouseX, pMouseY, pButton)){
            this.menu.characterButtonClicked();
            return true;
        }
        else if(this.inventoryButton.mouseClicked(pMouseX, pMouseY, pButton)){
            this.menu.inventoryButtonClicked();
            return true;
        }
        else if(this.partyButton.mouseClicked(pMouseX, pMouseY, pButton)){
            this.menu.partyButtonClicked();
            return true;
        }
        else{
            return false;
        }
    }
}
