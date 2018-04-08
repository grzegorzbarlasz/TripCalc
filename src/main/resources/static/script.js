var isPaySlide = true;
var isTransportSlide = false;
var isSleepSlide = false;
var isLocalSlide = false;
var isSpendsSlide = false;

$('#togglePaysArrow').on('click', function () {
    if (isPaySlide) {
        $('#payArrow').html('<i class="fas fa-caret-down"></i>');
        isPaySlide = false;
    } else {
        $('#payArrow').html('<i class="fas fa-caret-up"></i>');
        isPaySlide = true;
    }

    $('#togglePays').slideToggle(200);
});


$('#toggleTransportArrow').on('click', function () {
    if (isTransportSlide) {
        $('#transportArrow').html('<i class="fas fa-caret-down"></i>');
        isTransportSlide = false;
    } else {
        $('#transportArrow').html('<i class="fas fa-caret-up"></i>');
        isTransportSlide = true;
    }

    $('#toggleTransport').slideToggle(200);
});

$('#toggleSleepArrow').on('click', function () {
    if (isSleepSlide) {
        $('#sleepArrow').html('<i class="fas fa-caret-down"></i>');
        isSleepSlide = false;
    } else {
        $('#sleepArrow').html('<i class="fas fa-caret-up"></i>');
        isSleepSlide = true;
    }

    $('#toggleSleep').slideToggle(200);
});

$('#toggleLocalArrow').on('click', function () {
    if (isLocalSlide) {
        $('#localArrow').html('<i class="fas fa-caret-down"></i>');
        isLocalSlide = false;
    } else {
        $('#localArrow').html('<i class="fas fa-caret-up"></i>');
        isLocalSlide = true;
    }

    $('#toggleLocal').slideToggle(200);
});

var costID = 0;
var amountID = 0;


$("#addSpend").on('click', function () {
    costID += 1;
    amountID += 1;

    var template = '<div class="rem">';

    template += '<div class="form-group"><label for="cost' + costID + '">Rodzaj wydatku</label><input type="text" name="costs" id="cost' + costID + '" class="form-control"></div>';

    template += '<div class="form-group"><label for="amount' + amountID + '">Kwota</label><input type="text" name="amounts" id="amount' + amountID + '" class="form-control"></div>';

    template += '<span class="removeCost"><i class="fas fa-trash"></i></span>';

    template += '<hr>';

    template += '</div>';

    $("#toggleSpends").append(template);
});

$('#toggleSpendsArrow').on('click', function () {
    if (isSpendsSlide) {
        $('#spendsArrow').html('<i class="fas fa-caret-down"></i>');
        isSpendsSlide = false;
    } else {
        $('#spendsArrow').html('<i class="fas fa-caret-up"></i>');
        isSpendsSlide = true;
    }

    $('#toggleSpends').slideToggle(200);
});

$("#toggleSpends").on('click', '.removeCost', function () {
    $(this).parent().fadeOut(200, function () {
        $(this).remove();
    });
});
