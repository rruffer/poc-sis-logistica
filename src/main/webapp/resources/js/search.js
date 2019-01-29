/**
 * 
 */
function searchLeftMenu(criteria) {
    $('#menu-search').show();
    $('#menu-search li.dropdown').addClass('open');
    var menuResults = $('#menu-search ul.dropdown-menu[role="menu"]');
    $('#menu-search li.dropdown li').remove();

    if (criteria != null && criteria.length >= 2) {
        criteria = criteria.toLowerCase();
        var match = false;
        $('ul.sidebar-menu.tree li:not(.treeview, .header)').each(function () {
            var linkText = $(this).find('a span');
            if (linkText && typeof linkText.html() !== 'undefined' && linkText.html().toLowerCase().indexOf(criteria) !== -1) {
                var menuItem = $(this).clone();
                menuItem.removeClass('active');
                menuResults.append("<li>").append(menuItem).append("</li>");
                match = true;
            }
        });
        //console.log($('#menu-search ul.dropdown-menu[role="menu"]').html());
        if (!match) {
            $('#menu-search li.dropdown').removeClass('open');
            $('#menu-search').hide();
        }
    } else {
        $('#menu-search li.dropdown').removeClass('open');
        $('#menu-search').hide();
    }
}


function searchTopMenu(criteria) {
    $('#menu-search').show();
    $('#menu-search li.dropdown').addClass('open');
    var menuResults = $('#menu-search ul.dropdown-menu[role="menu"]');
    $('#menu-search li.dropdown li').remove();

    if (criteria != null && criteria.length >= 2) {
        criteria = criteria.toLowerCase();
        var match = false;
        $('ul.nav.navbar-nav ul.dropdown-menu[role="menu"] > li').each(function () {
            var linkText = $(this).find('a span:not(.label)');
            if (linkText && linkText.html().toLowerCase().indexOf(criteria) !== -1) {
                menuResults.append("<li>").append($(this).clone()).append("</li>");
                match = true;
            }
        });
        if (!match) {
            $('#menu-search li.dropdown').removeClass('open');
        }
    } else {
        $('#menu-search li.dropdown').removeClass('open');
    }
}

function hideMenuResults() {
    setTimeout(function () {
        $('#menu-search li.dropdown').removeClass('open');
        $('#menu-search').hide();
    }, 150);
}
