/*
 * Panel Draft 0.2.2
 * for jQuery UI
 *
 * Copyright (c) 2009 idle sign
 *
 * Depends:
 *	ui.core.js
 */
(function($) {

	$.widget('ui.panel', {

		// create panel
		_init: function() {
			
			if (this.element.is('div')) {
				var o = this.options,
					self = this;

				this.panelBox = this.element;
				o.width = this.panelBox.css('width');
				this.panelBox.attr('role', 'panel')
				// prevent blinking
				this.panelBox.hide();
				this.headerBox = this.element.children().eq(0);
				this.contentBox = this.element.children().eq(1);
				this.headerBox.wrapInner('<div><span></span></div>');
				// need separate titleBox and titleTextBox to avoid possible collapse/draggable issues
				this.titleBox = this.headerBox.children().eq(0);
				this.titleTextBox = this.titleBox.children().eq(0);
				this.headerBox.prepend('<span></span>')
				this.rightBox = this.headerBox.children().eq(0).addClass(o.rightboxClass);

				// setting up controls
				if (o.controls!=false){
					// suppose 'o.controls' should be a ui.toolbar control
					this.rightBox.append('<span></span>');
					this.controlsBox = this.rightBox.children().eq(0).addClass(o.controlsClass).html(o.controls);
				}

				// styling
				this.panelBox.addClass(o.widgetClass);
				this.headerBox.addClass(o.headerClass);
				this.titleBox.addClass(o.titleClass);
				this.titleTextBox.addClass(o.titleTextClass);
				this.contentBox.addClass(o.contentClass);

				// collapsibility
				if (o.collapsible){					
					switch (o.collapseType) {
						case 'slide-right':
							alert(o.collapseType);
							if(!o.controls)
								this.rightBox.append('<span></span>');
							this.rightBox.append('<span><span/></span>');
							this.collapsePanel = this.rightBox.children().eq(1).addClass(o.collapsePnlClass);
							this.collapseButton =  this.collapsePanel.children().eq(0).addClass(o.slideRIcon);
							this.iconBtnClpsd = o.slideRIconClpsd;
							this.iconBtn = o.slideRIcon;
							if(!o.controls)
								this.ctrlBox = this.rightBox;
							this.ctrlBox = this.controlsBox;
							break;
						case 'slide-left':
							alert(o.collapseType);
							this.headerBox.prepend('<span><span/></span>');
							this.collapsePanel = this.headerBox.children().eq(0).addClass(o.collapsePnlClass);
							this.collapseButton =  this.collapsePanel.children().eq(0).addClass(o.slideLIcon);
							this.iconBtnClpsd = o.slideLIconClpsd;
							this.iconBtn = o.slideLIcon;
							this.ctrlBox = this.rightBox;
							break;
						default:
							alert("default "+o.collapseType);
							this.headerBox.prepend('<span><span/></span>');
							this.collapseButton = this.headerBox.children().eq(0).addClass(o.headerIcon);
							this.iconBtnClpsd = o.headerIconClpsd;
							this.iconBtn = o.headerIcon;
							this.ctrlBox = this.controlsBox;
							break;
					}

					this._buttonHover(this.collapseButton);
					this.collapseButton.addClass(o.iconClass);
					if (o.event) {
						this.collapseButton.bind((o.event) + ".panel", function(event) { return self._clickHandler.call(self, event, this); });
						this.titleTextBox.bind((o.event) + ".panel", function(event) { return self._clickHandler.call(self, event, this); });
					}

					// panel collapsed
					if (o.collapsed) {
						// trigger collapse
						this._toggle(0);
					}
				}

				alert(this.titleBox.html());
				this.panelBox.show();
			}

		},

		_clickHandler: function(event, target){
			var o = this.options;
			
			if (o.disabled) return false;
			this._toggle(o.collapseSpeed);
			return false;
		},
		
		_toggle: function (collapseSpeed){
			var o = this.options,
				btn = this.collapseButton,
				ibc = this.iconBtnClpsd,
				ib = this.iconBtn,
				panelBox = this.panelBox,
				contentBox = this.contentBox,
				headerBox = this.headerBox,
				titleTextBox = this.titleTextBox,
				ctrlBox = this.ctrlBox;

			// split toggle into 'fold' and 'unfold' actions and handle callbacks
			if (contentBox.css('display')=='none') this._trigger("unfold");
			else this._trigger("fold");

			if (ctrlBox) ctrlBox.toggle(0);
			if (o.collapseType=='default'){
				// different content sliding animation
				if (collapseSpeed==0) {
					if (ctrlBox) ctrlBox.hide();
					contentBox.hide();
				} else contentBox.slideToggle(collapseSpeed);
			} else {
				if (collapseSpeed==0) {
					// reverse collapsed option for immediate folding
					o.collapsed=false;
					if (ctrlBox) ctrlBox.hide();
					contentBox.hide();
				} else contentBox.toggle();

				// vertical text workaround - to be replaced with more clever in future
				if (o.collapsed==false){
					headerBox.attr('align','center');
					titleTextBox.html(titleTextBox.text().replace(/(.)/g, '$1<BR>'));
					panelBox.animate( {width: '2.4em'}, collapseSpeed );
				} else {
					headerBox.attr('align','left');
					titleTextBox.html(titleTextBox.text().replace(/<BR>/g, ' '));
					panelBox.animate( {width: o.width}, collapseSpeed );
				}

				o.collapsed = !o.collapsed;
			}

			// css animation for header and button
			btn.toggleClass(ibc).toggleClass(ib);
			headerBox.toggleClass('ui-corner-all');
		},

		destroy: function(){
			var o = this.options;

			this.headerBox
				.html(this.titleTextBox.html())
				.removeClass(o.headerClass);
			this.contentBox
				.removeClass(o.contentClass);
			this.panelBox
				.removeAttr('role')
				.unbind('.panel')
				.removeClass(o.widgetClass);
		},

		_buttonHover: function(el){
			var o = this.options;

			el
				.bind('mouseover', function(){ $(this).addClass(o.hoverClass); })
				.bind('mouseout', function(){ $(this).removeClass(o.hoverClass); })
		}

	});

	$.extend($.ui.panel, {
		version: '0.2.2',
		defaults: {
			event: 'click',
			collapsible: true,
			collapseType: 'default',
			collapsed: false,
			collapseSpeed: 'fast',
			// suppose that we need ui.toolbar with controls here
			controls: false,
			// styling
			widgetClass: 'ui-helper-reset ui-widget ui-panel',
			headerClass: 'ui-helper-reset ui-widget-header ui-panel-header ui-corner-top',
			contentClass: 'ui-helper-reset ui-widget-content ui-panel-content ui-corner-bottom',
			rightboxClass: 'ui-panel-rightbox',
			controlsClass: 'ui-panel-controls',
			titleClass: 'ui-panel-title',
			titleTextClass: 'ui-panel-title-text',
			iconClass: 'ui-icon',
			hoverClass: 'ui-state-hover',
			collapsePnlClass: 'ui-panel-clps-pnl',
			//icons
			headerIconClpsd: 'ui-icon-triangle-1-e',
			headerIcon: 'ui-icon-triangle-1-s',
			slideRIconClpsd: 'ui-icon-arrowthickstop-1-w',
			slideRIcon: 'ui-icon-arrowthickstop-1-e',
			slideLIconClpsd: 'ui-icon-arrowthickstop-1-e',
			slideLIcon: 'ui-icon-arrowthickstop-1-w'
		}
	});


})(jQuery);