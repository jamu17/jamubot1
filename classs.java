import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class classs extends TelegramLongPollingBot {

    private final String BOT_TOKEN = "7815647017:AAGw3IbC1RMZgvZspPCBGPnLPVbBBcqAKvU"; // Replace with your bot token
    private final String BOT_USERNAME = "@Qpalnabot"; // Replace with your bot username

    @Override
    public void onUpdateReceived(Update update) {
        // Check if the update has a message and if it contains text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().toLowerCase();

            // Check for specific words and respond accordingly
            if (messageText.contains("love") || messageText.contains("miss") || messageText.contains("forever") || messageText.contains("mahal")
                    || messageText.contains("burat") || messageText.contains("tite") || messageText.contains("loyal")) {
                String response = "bobo, tanga, tarantado";
                try {
                    // Send the response message
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), response));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            // Check for new chat members and send a welcome message if needed
            if (update.getMessage().getNewChatMembers() != null && !update.getMessage().getNewChatMembers().isEmpty()) {
                StringBuilder welcomeMessage = new StringBuilder("Welcome to the group, ");

                boolean firstMember = true;
                for (var member : update.getMessage().getNewChatMembers()) {
                    if (firstMember) {
                        welcomeMessage.append(member.getFirstName());
                        firstMember = false;
                    } else {
                        welcomeMessage.append(", ").append(member.getFirstName());
                    }
                }

                welcomeMessage.append("! Here are the rules:\n")
                        .append("1. Be respectful.\n")
                        .append("2. No spam.\n")
                        .append("3. Follow the group guidelines.\n")
                        .append("4. Mag I labyu lagi kay Jo.\n");

                try {
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), welcomeMessage.toString()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
