package com.ccfraser.muirwik.starterapp.meetingrooms

import com.ccfraser.muirwik.components.accordion.mAccordion
import com.ccfraser.muirwik.components.accordion.mAccordionDetails
import com.ccfraser.muirwik.components.accordion.mAccordionSummary
import com.ccfraser.muirwik.components.mIcon
import com.ccfraser.muirwik.components.mTypography
import com.ccfraser.muirwik.components.spacingUnits
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.width
import react.*
import styled.css
import styled.styledDiv

class London : RComponent<RProps, RState>() {
    private var expandedItem: String? = null

    private fun handleExpanded(expanded: Boolean, panelName: String) {
        setState { expandedItem = if (expanded) panelName else null }
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                padding(2.spacingUnits)
                width = 100.pct
            }
            mAccordion(expandedItem == "panel1", onChange = { _, expanded -> handleExpanded(expanded, "panel1") }) {
                mAccordionSummary(expandIcon = mIcon("expand_more", addAsChild = false)) {
                    mTypography("Camera")
                }
                mAccordionDetails {
                    mTypography(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada lacus ex, " +
                                "sit amet blandit leo lobortis eget."
                    )
                }
            }
            mAccordion(expandedItem == "panel2", onChange = { _, expanded -> handleExpanded(expanded, "panel2") }) {
                mAccordionSummary(expandIcon = mIcon("expand_more", addAsChild = false)) {
                    mTypography("Codec")
                }
                mAccordionDetails {
                    mTypography(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada lacus ex, " +
                                "sit amet blandit leo lobortis eget."
                    )
                }
            }
            mAccordion(expandedItem == "panel3", onChange = { _, expanded -> handleExpanded(expanded, "panel3") }) {
                mAccordionSummary(expandIcon = mIcon("expand_more", addAsChild = false)) {
                    mTypography("Phone")
                }
                mAccordionDetails {
                    mTypography(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada lacus ex, " +
                                "sit amet blandit leo lobortis eget."
                    )
                }
            }
        }
    }
}

fun RBuilder.london() = child(London::class) {}