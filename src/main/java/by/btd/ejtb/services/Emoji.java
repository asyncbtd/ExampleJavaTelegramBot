package by.btd.ejtb.services;

public enum Emoji {

    //smiles
    GRINNING('\uD83D', '\uDE24'),
    SMILEY('\uD83D', '\uDE03'),
    SMILE('\uD83D', '\uDE04'),
    GRIN('\uD83D', '\uDE01'),
    SATISFIED('\uD83D', '\uDE06'),
    FACE_HOLDING_BACK_TEARS('\uD83E', '\uDD79'),
    SWEAT_SMILE('\uD83D', '\uDE05'),
    JOY('\uD83D', '\uDE02'),
    ROLLING_ON_THE_FLOOR_LAUGHING('\uD83E', '\uDD23'),
    SMILING_FACE_WITH_TEAR('\uD83E', '\uDD72'),
    RELAXED('\u263A', '\uFE0F'),
    BLUSH('\uD83D', '\uDE0A'),
    INNOCENT('\uD83D', '\uDE07'),
    SLIGHTLY_SMILING_FACE('\uD83D', '\uDE42'),
    UPSIDE_DOWN_FACE('\uD83D', '\uDE43'),
    WINK('\uD83D', '\uDE09'),
    RELIEVED('\uD83D', '\uDE0C'),
    HEART_EYES('\uD83D', '\uDE0D'),
    SMILING_FACE_WITH_3_HEARTS('\uD83E', '\uDD70'),
    KISSING_HEART('\uD83D', '\uDE18'),
    KISSING('\uD83D', '\uDE17'),
    KISSING_SMILING_EYES('\uD83D', '\uDE19'),
    KISSING_CLOSED_EYES('\uD83D', '\uDE1A'),
    YUM('\uD83D', '\uDE0B'),
    STUCK_OUT_TONGUE('\uD83D', '\uDE1B'),
    STUCK_OUT_TONGUE_CLOSED_EYES('\uD83D', '\uDE1D'),
    STUCK_OUT_TONGUE_WINKING_EYE('\uD83D', '\uDE1C'),
    CRAZY_FACE('\uD83E', '\uDD2A'),
    FACE_WITH_RAISED_EYEBROW('\uD83E', '\uDD28'),
    FACE_WITH_MONOCLE('\uD83E', '\uDDD0'),
    NERD_FACE('\uD83E', '\uDD13'),
    SUNGLASSES('\uD83D', '\uDE0E'),
    DISGUISED_FACE('\uD83E', '\uDD78'),
    STAR_STRUCK('\uD83E', '\uDD29'),
    PARTY('\uD83E', '\uDD73'),
    SMIRK('\uD83D', '\uDE0F'),
    UNAMUSED('\uD83D', '\uDE12'),
    DISAPPOINTED('\uD83D', '\uDE1E'),
    PENSIVE('\uD83D', '\uDE14'),
    WORRIED('\uD83D', '\uDE1F'),
    CONFUSED('\uD83D', '\uDE15'),
    SLIGHTLY_FROWNING_FACE('\uD83D', '\uDE41'),
    WHITE_FROWNING_FACE('\u2639', '\uFE0F'),
    PERSEVERE('\uD83D', '\uDE23'),
    CONFOUNDED('\uD83D', '\uDE16'),
    TIRED_FACE('\uD83D', '\uDE2B'),
    WEARY('\uD83D', '\uDE29'),
    PLEADING_FACE('\uD83E', '\uDD7A'),
    CRY('\uD83D', '\uDE22'),
    SOB('\uD83D', '\uDE2D'),
    TRIUMPH('\uD83D', '\uDE24'),
    ANGRY('\uD83D', '\uDE20'),
    RAGE('\uD83D', '\uDE21'),
    FACE_WITH_SYMBOLS_OVER_MOUTH('\uD83E', '\uDD2C'),
    EXPLODING_HEAD('\uD83E', '\uDD2F'),
    FLUSHED('\uD83D', '\uDE33'),
    HOT_FACE('\uD83E', '\uDD75'),
    COLD_FACE('\uD83E', '\uDD76'),

    /* FACE_IN_CLOUDS('\uD83D\uDE36\u200D\uD83C\uDF2B\uFE0F'),
    I'm surprised that there are emoticons made of more than two chars, perhaps in the future a separate enum will be made for such emoticons */

    SCREAM('\uD83D', '\uDE31'),
    FEARFUL('\uD83D', '\uDE28'),
    COLD_SWEAT('\uD83D', '\uDE30'),
    DISAPPOINTED_RELIEVED('\uD83D', '\uDE25'),
    SWEAT('\uD83D', '\uDE13'),
    HUGGING_FACE('\uD83E', '\uDD17'),
    HMM('\uD83E', '\uDD14'),
    FACE_WITH_PEEKING_EYE('\uD83E', '\uDEE3'),
    FACE_WITH_HAND_OVER_MOUTH('\uD83E', '\uDD2D'),
    FACE_WITH_OPEN_EYES_AND_HAND_OVER_MOUTH('\uD83E', '\uDEE2'),
    SALUTING_FACE('\uD83E', '\uDEE1'),
    SHUSHING_FACE('\uD83E', '\uDD2B'),
    MELTING_FACE('\uD83E' ,'\uDEE0'),
    LIAR('\uD83E', '\uDD25'),
    NO_MOUTH('\uD83D', '\uDE36'),
    DOTTED_LINE_FACE('\uD83E', '\uDEE5'),
    NEUTRAL_FACE('\uD83D', '\uDE10'),
    FACE_WITH_DIAGONAL_MOUTH('\uD83E', '\uDEE4'),
    EXPRESSIONLESS('\uD83D', '\uDE11'),
    SHAKING_FACE('\uD83E', '\uDEE8'),
    GRIMACING('\uD83D', '\uDE2C'),
    FACE_WITH_ROLLING_EYES('\uD83D', '\uDE44'),
    HUSHED('\uD83D', '\uDE2F'),
    FROWNING('\uD83D', '\uDE26'),
    ANGUISHED('\uD83D', '\uDE27'),
    OPEN_MOUTH('\uD83D', '\uDE2E'),
    ASTONISHED('\uD83D', '\uDE32'),
    YAWNING_FACE('\uD83E', '\uDD71'),
    SLEEPING('\uD83D', '\uDE34'),
    DROOL('\uD83E', '\uDD24'),
    SLEEPY('\uD83D', '\uDE2A'),

    /* FACE_EXHALING('\uD83D\uDE2E\u200D\uD83D\uDCA8'),
    Another complex emoticon */

    DIZZY_FACE('\uD83D', '\uDE35'),

    /* FACE_WITH_SPIRAL_EYES('\uD83D\uDE35\u200D\uD83D\uDCAB'),
    Another complex emoticon */

    ZIPPER_MOUTH_FACE('\uD83E', '\uDD10'),
    WOOZY_FACE('\uD83E', '\uDD74'),
    SICK('\uD83E', '\uDD22'),
    FACE_VOMITING('\uD83E', '\uDD2E'),
    SNEEZE('\uD83E', '\uDD27'),
    MASK('\uD83D', '\uDE37'),
    FACE_WITH_THERMOMETER('\uD83E', '\uDD12'),
    FACE_WITH_HEAD_BANDAGE('\uD83E', '\uDD15'),
    MONEY_MOUTH_FACE('\uD83E', '\uDD11'),
    FACE_WITH_COWBOY_HAT('\uD83E', '\uDD20'),
    SMILING_IMP('\uD83D', '\uDE08'),
    IMP('\uD83D', '\uDC7F'),
    JAPANESE_OGRE('\uD83D', '\uDC79'),
    JAPANESE_GOBLIN('\uD83D', '\uDC7A'),
    CLOWN_FACE('\uD83E', '\uDD21'),
    POO('\uD83D', '\uDCA9'),
    GHOST('\uD83D', '\uDC7B'),
    SKELETON('\uD83D', '\uDC80'),
    SKULL_AND_CROSSBONES('\u2620', '\uFE0F'),
    ALIEN('\uD83D', '\uDC7D'),
    SPACE_INVADER('\uD83D', '\uDC7E'),
    ROBOT_FACE('\uD83E', '\uDD16'),
    JACK_O_LANTERN('\uD83C', '\uDF83'),
    SMILEY_CAT('\uD83D', '\uDE3A'),
    SMILE_CAT('\uD83D', '\uDE38'),
    JOY_CAT('\uD83D', '\uDE39'),
    HEART_EYES_CAT('\uD83D', '\uDE3B'),
    SMIRK_CAT('\uD83D', '\uDE3C'),
    KISSING_CAT('\uD83D', '\uDE3D'),
    SCREAM_CAT('\uD83D', '\uDE40'),
    CRYING_CAT_FACE('\uD83D', '\uDE3F'),
    POUTING_CAT('\uD83D', '\uDE3E');

    //hands

    final Character firstChar;
    final Character secondChar;

    Emoji(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.firstChar != null) {
            stringBuilder.append(this.firstChar);
        }
        if (this.secondChar != null) {
            stringBuilder.append(this.secondChar);
        }

        return stringBuilder.toString();
    }
}
